
package ch18.exam28;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
// 받는쪽 먼저 실행해줘야 함 : 실행순서 Receive - > Send

public class ReceiveExample {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket datagramSocket = new DatagramSocket(50002);
        //받는 쪽은 반드시 포트번호가 지정되어야 함**
        
        //비어있는 데이터그램 패킷을 만든다. // 데이터그램의 저장공간을 만드는 것
        DatagramPacket datagramPacket = new DatagramPacket(new byte[100],100);//최대 100 바이트까지 읽겠다
       
        // 데이터를 받는다.
        datagramSocket.receive(datagramPacket); 
       
        byte[] data = datagramPacket.getData();
        int readBytes = datagramPacket.getLength();
        String strData = new String(data, 0 , readBytes);
//저장공간이 100인데, 실제 넘어 온 것은 더 적을수도 있으므로 읽은데까지 표시할라고
                
        System.out.println("받은 데이터: " + strData);
        
        datagramSocket.close();
    }
}
