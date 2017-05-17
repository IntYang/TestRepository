
package ch18.exam29.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ServerController implements Initializable {
	 public static ServerController instance; // 자기 자신의 인스턴트를 정적으로 삽입해서

	 @FXML
	 private Button btnStartStop;
	 @FXML
	 private TextArea txtDisplay;

	 
	 private ExecutorService executorService;
	 private ServerSocket serverSocket;
	 private List<Client> connections = new Vector<Client>(); // 스레드 들이 벡터 쓰도록
	
	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
			ServerController.instance = this; // 초기화
			btnStartStop.setOnAction(e->handBtnStartStop(e));
	 }	 

	 private void handBtnStartStop(ActionEvent e) {
			
			if(btnStartStop.getText().equals("시작")){
				 startServer();
			}
			else if(btnStartStop.getText().equals("멈춤")){
				 stopServer();
			}
			
	 }
	 private void startServer(){
			// 스레드풀 생성
			executorService = Executors.newFixedThreadPool(100);
			
			//서버 소켓 생성
			try{
				 serverSocket = new ServerSocket();
				 serverSocket.bind(new InetSocketAddress("192.168.3.", 50001));
			
			
			}
			catch(IOException ex)
			{
				 stopServer();
				 return;
			}
			
			
			// 연결 수락 작업 정의
			Runnable acceptTask=()->{
				 Platform.runLater(()->{
						// UI 변경 코드
						btnStartStop.setText("멈춤");
						display("서버 시작...");
				 
				 });
				 
				 while(true){
						try {
							 // 수락코드
							 Socket socket = serverSocket.accept();
							 // 연결된 클라이언트 정보 출력
							 String clientInfo = "[연결 수락: " + socket.getRemoteSocketAddress() + "]";
							 Platform.runLater(()->{
									display(clientInfo);
							 });
							 
							 //통ㄴ신용 클라이언트 생성
							 Client client = new Client(socket);
							 // Vector에 Client 저장
							 connections.add(client);
							 // 총 Client 수 출력
							 Platform.runLater(()->{
									display("[연결 개수: " + connections.size() + "]");
							 
							 });
							 
							 
						} catch (IOException ex) {
							 stopServer();
							 break;
						}
				 }
			
			};
			
			// 스레드풀의 작업큐에 작업 넣기
			executorService.submit(acceptTask);
			
			
			
			
			
			btnStartStop.setText("멈춤");
			display("서버 시작");
	 }
	 public void stopServer(){ // 작업스레드
		
			try {
				 /*
				 for(Client client : connections){
						client.socket.close(); // 모튼 클라이언트의 소켓을 종료 시킴
						connections.remove(client); 중간에 제거 하면 for문은 인식 못하고 계속 돌아버리니까 다 끝나고 클리어해야 안전
				 }
				 
				 connections.clear(); // 다 닫고 클리어
				 */
				 
				 Iterator<Client> iterator = connections.iterator();
				 while(iterator.hasNext()){
						Client client = iterator.next();
						client.socket.close();
						iterator.remove();
				 }
				 
				 	executorService.shutdownNow();// 인터럽트가 들어갈 틈이 없기 때문에 강제 종료가 안 되는 것
					serverSocket.close();
			
				 Platform.runLater(()->{
				 btnStartStop.setText("시작");
				 display("서버 멈춤");
				 
			});
			} catch (IOException ex) {
				 ex.printStackTrace();
			}
	 }
	 private void display(String text){
			txtDisplay.appendText(text+"\n");
	 }
	 class Client{
			Socket socket;
			
			Client(Socket socket){
				 this.socket = socket;
				 receive();
			}
			
			void receive(){ // 클라이언트가 보내는 메시지 받기 위한 것
				 Runnable receiveTask = () -> {
				 //클라이언트가 언제 올지 모르니 무한 대기해야함
						
							 try {
									while(true){
										 InputStream inputStream = socket.getInputStream();
										 byte[] byteArr = new byte[100];
										 int readBytes = inputStream.read(byteArr);
										 if(readBytes == -1)
												throw new Exception();
										 String strData = new String(byteArr, 0, readBytes);
										 for(Client client : connections){ // 작업 스레드가 처리
												client.send(strData);
										 }
									}
							 } 
							 catch (Exception ex) {
									try{
										 String clientInfo = "[연결 끊기: " + socket.getRemoteSocketAddress() + "]";
										 Platform.runLater(()->display(clientInfo));
										 this.socket.close();
										 connections.remove(Client.this);
										 display("[연결 개수: " + connections.size() + "]");
									}catch(IOException e){
										 
									}
							 } 
						

				 
				 
				 };
				 
				 // 스레드의 작업 큐에 넣기
				 executorService.submit(receiveTask);
			
				 
			}
			
			void send(String message){
				 try {
						OutputStream os = socket.getOutputStream();
						byte[] byteArr = message.getBytes();
						os.write(byteArr);
						os.flush();
						
				 } catch (IOException ex) {
						connections.remove(Client.this);
						try {
							 socket.close();
						} catch (IOException ex1) {}
				 }
				 
			}
	 }
	 
}
