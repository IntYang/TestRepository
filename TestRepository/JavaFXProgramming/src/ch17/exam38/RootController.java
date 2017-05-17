
package ch17.exam38;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


public class RootController implements Initializable {

	 @FXML
	 private ProgressBar progressBar;
	 @FXML
	 private Label label;
	 @FXML
	 private Label lblWorkDone;
	 @FXML
	 private Button btnStart;
	 @FXML
	 private Button btnStop;
	 
	 private Task<Integer> task; // 작업의 결과가 정수가 나온다
	 @FXML
	 private Label lblResult;

	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
			btnStart.setOnAction(e->handleBtnStart(e));
			btnStop.setOnAction(e->handleBtnStop(e));
	 }	 

	 private void handleBtnStart(ActionEvent e) {
			task = new Task<Integer>(){
				 @Override
				 protected Integer call() throws Exception {
						int result = 0;
						for(int i=0;i<=100;i++){ // 작업 스레드(값만 바꿔주는 역할)
							 result+=100;
							 System.out.println(i);
							 
							// 프로그래스 바 올라가게(작업 상태 나타내는 바)
							 // 없으면 왔다갔다 거리기만 함
							 // 이 안에서는 UI 변경 작업 불가
							 //how1
							 //updateProgress(i,100);
							// updateMessage(String.valueOf(i));
							
							//how2
							double value = i; // final 특성으로 생성되기 때문에 runLAter 안에 들어감
							 Platform.runLater(()->{
									progressBar.setProgress(value/100);
									lblWorkDone.setText(String.valueOf(value));
						});
							
							
							 if(isCancelled()){ // 멈추는 역할
									break;
							 }
							 
							 try{
									Thread.sleep(100);
							 }
							 catch(Exception e){
									break;
							 }
						}
						return result; 
				 }

				// 자바FX 어플리케이션 스레드가 실행
				 @Override
				 protected void succeeded() { // 작업 끝남
//						System.out.println("succeeded: " + Thread.currentThread().getName());
						int result = getValue();
						lblResult.setText(String.valueOf(result)); // UI 변경 작업 가능, fx 어플리케이션 스레드가 실행하니까
				 }
				 // 자바FX 어플리케이션 스레드가 실행
				 @Override
				 protected void cancelled() {
						lblResult.setText("작업 취소됨");
				 }
				 // 자바FX 어플리케이션 스레드가 실행
				 @Override
				 protected void failed() {
				 }
			
				 
				 
				 
				 
				 
			};
			
			// 스레드 시작 전에
			// 속성 단방향 바인드
			// 실제 UI를 바꿔주는 스레드
			//how1
			//1 progressBar.progressProperty().bind(task.progressProperty()); // 자바FX 어플리케이션 스레드, 위의 Void call과 다른 스레드
			//1 lblWorkDone.textProperty().bind(task.messageProperty());// 자바FX 어플리케이션 스레드
			
			
			Thread thread = new Thread(task);
			thread.setDaemon(true);
			thread.start();
	 }

	 private void handleBtnStop(ActionEvent e) {
			
			task.cancel(); // 
	 }
	 
}
