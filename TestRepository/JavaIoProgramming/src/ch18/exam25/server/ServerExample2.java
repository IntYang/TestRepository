

package ch18.exam25.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server Program
 * ClientExample2.java와 통신하는 코드
 * 클라이언트에서 서버 프로그램에 보낸다. c->s , s->c
 * Echo 프로그램
 * client 1개만을 위한 server
 * 통신 실행문에 while문 넣으면 서버1 : 클라이언트다수(일대다)
 * 스레드 개수: 메인 스레드(1개)
 * accept()용 스레드, 통신용 스레드 새로 만들기 필요 ->  스레드 병렬처리 필요
 * 클라이언트 몇 개 접속할 지 모를 때(클라이언트 불특정 다수), 
 * 클라이언트 개수 폭주하면 서버 자원(메모리) 제어 어려움
 * 스레드 병렬 처리에서 제어 처리 필요 -> 스레드 풀(제한된 개수만 허용한다) 필요
 * 
 */
public class ServerExample2 {

    public static void main(String[] args) {
        
         ServerSocket serverSocket = null;
        try{ 
            // ServerSocket 생성
            serverSocket = new ServerSocket();
            // 포트와 바인딩
            serverSocket.bind(new InetSocketAddress(50001));
           
            // 연결 기다리기
            // 서버 계속 열어두기 위해 while문 추가
            while(true){
            Socket socket = serverSocket.accept();
            
            
            // 통신하기 -> 클라이언트와 반대로 스트림 생성
            InputStream is = socket.getInputStream();
            
             //2) 서버에서 보낸 내용 받기
             byte[] data = new byte[100];
             int readByte = is.read(data);
             
             if(readByte == -1){ // 클라이언트가 암것도 안보내고 혼자 종료된 경우
                 throw new IOException("클라이언트가 정상 종료됨");
                         
             }
             
             
             
             String strData = new String(data, 0, readByte, "UTF-8");
             System.out.println("받은 데이터: " + strData);
            
             
            //3) 이제, 서버에서 클라이언트로 보낸다.
            OutputStream os = socket.getOutputStream();
            
            data = strData.getBytes();
             os.write(data);
             os.flush();
            System.out.println("데이터 보내기 성공");
            
            // 연결 끊기
            socket.close();
            }
        
        }
        
        //if 막바로 오게 하려면?
        catch(IOException ex){ 
            System.out.println(ex.getMessage());
        }
        
        if(serverSocket != null && serverSocket.isClosed()){ // 서버 소켓이 현재 50001 포트를 사용하고 있느냐
            //Seversocket 닫기
             try{ // 사용하고 있으면 소켓 닫아줘라 (50001번 포트해제)
                 serverSocket.close();
               }catch(IOException ex1){}
        }
           
        
        
    }
}
