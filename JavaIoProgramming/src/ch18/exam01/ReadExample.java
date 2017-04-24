package ch18.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//2017.04.12 수업 내용
// import : ctrl + shift + i
public class ReadExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = ReadExample.class.getResource("test.txt").getPath();
//        InputStream is = new FileInputStream("E:\\IoTCourse\\NetBeansWorkspace\\JavaIoProgramming\\src\\ch18\\exam01\\test.txt");
        InputStream is = new FileInputStream(path);
        
        
        
// while문 조건 1
        while (true) {
            int v1 = is.read(); // 바이트를 읽어 오기 때문에 숫자로 읽음
            if (v1 == -1) {
                break;
            }
            System.out.print((char) v1); // 문자코드를 문자 자체로 나타내도록 변환
        }
        System.out.println("-------------------------------------------------------");
// while문 조건 2        
        int data = -1;
        while ((data = is.read()) != -1) {
            int v2 = is.read(); // 바이트를 읽어 오기 때문에 숫자로 읽음
            
            System.out.print((char) v2); // 문자코드를 문자 자체로 나타내도록 변환
        }
       
        is.close();
    }
}


