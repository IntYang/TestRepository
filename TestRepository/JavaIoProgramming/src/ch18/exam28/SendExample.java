

package ch18.exam28;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class SendExample {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        
        //보내고자 하는 데이터
        String strData = "Hello";
        byte[] data = strData.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(
        
                data,
                data.length,
                new InetSocketAddress("192.168.3.36", 50002) // 자신의IP사용할것
     
        );
        
         //데이터를 보낸다.       
        datagramSocket.send(datagramPacket); 
        
        // 소켓 다 썼으면 닫아줘
        datagramSocket.close();
        
        
        
        
    }
}
