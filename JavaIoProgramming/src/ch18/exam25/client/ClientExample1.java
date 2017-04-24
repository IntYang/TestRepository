/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch18.exam25.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;


public class ClientExample1 {
    public static void main(String[] args) {
        Socket socket = null;
        //how1
        try {
            socket = new Socket("192.168.3.36",50001); // 서버의 IP 주소를 준다
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        if(!socket.isClosed()){
          try{
              socket.close();
          }catch(IOException ex){}
      }
        
        
        
        //how2
         try {
           socket = new Socket();
           socket.connect(new InetSocketAddress("192.168.3.36", 50001));
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
