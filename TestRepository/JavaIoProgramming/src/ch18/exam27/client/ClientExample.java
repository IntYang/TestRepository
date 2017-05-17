
package ch18.exam27.client;

import ch18.exam25.client.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Client Program
 * SeverExample2.java와 통신하는 코드
 * 클라이언트에서 서버 프로그램에 보낸다. c->s , s->c
 * Echo 프로그램
 */
public class ClientExample {
    public static void main(String[] args) {
        Socket socket = null;

        
        //how2
         try {
            //소켓 생성
           socket = new Socket();
           
           //연결 요청
           socket.connect(new InetSocketAddress("192.168.3.36", 50001));
           
           
           
           //통신하기 -> 서버와 반대로 스트림 생성
           
             // 1) 서버로 보낸다.
             
             OutputStream os = socket.getOutputStream();
             String strData = "자바어려워";
             byte[] data = strData.getBytes("UTF-8");
             os.write(data);
             os.flush();
             System.out.println("데이터 보내기 성공");
             
             
             // 4) 서버에서 보낸 내용 받는다.
             InputStream is = socket.getInputStream();
             
             data = new byte[100];
             int readByte = is.read(data);
             strData = new String(data, 0, readByte);
             
              System.out.println("받은 데이터: " + strData);
                   
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        if(!socket.isClosed()){
          try{
              socket.close();
          }catch(IOException ex){}
      }
        
        
    }
}
