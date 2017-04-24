
package ch18.exam18;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PrimitiveDataExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int value = 10;
        double value2 = 2.5;
        boolean value3 = false;
        String value4 = "자바";
        
        //test.dat에 위의 값들 저장하고 싶을 때
        
        OutputStream os = new FileOutputStream("src/ch18/test.dat"); 
        //파일 확장명 txt 안쓰는 이유: int 문자 아니니까, 바이너리 데이터 형식으로 저장되니 txt는 문자로 저장
        DataOutputStream dos = new DataOutputStream(os);
        
        dos.writeInt(value);
        dos.writeDouble(value2);
        dos.writeBoolean(value3);
        dos.writeUTF(value4);
        
     // 우리가 text로 열 수가 없다. 바이너리 데이터이기 때문에.
        dos.flush();
        dos.close();
        os.flush();
        os.close();
        
        InputStream is = new FileInputStream("src/ch18/test.dat");
        DataInputStream dis = new DataInputStream(is);
        int readValue = dis.readInt();
        
        double readDouble = dis.readDouble();
        boolean readBoolean = dis.readBoolean();
        String readStr = dis.readUTF();
        
        
        System.out.println(readValue);
        System.out.println(readDouble);
        System.out.println(readBoolean);
        System.out.println(readStr);

        dis.close();
        is.close();
           
        
    }
}
