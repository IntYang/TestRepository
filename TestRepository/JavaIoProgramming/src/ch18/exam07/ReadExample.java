package ch18.exam07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
//2017.04.12 수업 내용
// import : ctrl + shift + i
public class ReadExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = ReadExample.class.getResource("test.txt").getPath(); // 상대적 경로로 찾기
        Reader reader = new FileReader(path);
        
        char[] data = new char[3];
        int readBytes = reader.read(data);
       
        String str = new String(data);
        System.out.println(readBytes);
        System.out.println(str);
        
        readBytes = reader.read(data);
        str = new String(data);
        System.out.println(readBytes);
        System.out.println(str);
     
        readBytes = reader.read(data);
        str = new String(data, 0, readBytes);
        System.out.println(readBytes);
        System.out.println(str);
     
        
        reader.close();
    }

}
