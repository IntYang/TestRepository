package ch18.exam04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// 2017.04.12 수업 내용
public class WriteExample {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
//        String path = WriteExample.class.getResource("test.txt").getPath(); // 상대적 경로로 찾기 -> build에 가있다
//        OutputStream os = new FileOutputStream("E:\\IoTCourse\\NetBeansWorkspace\\JavaIoProgramming\\src\\ch18\\exam03\\test.txt");
        OutputStream os = new FileOutputStream("src\\ch18\\exam04\\test.txt"); // 개발 테스트용
        
        byte[] data = {97,98,99};
//        byte[] data1 = "abc".getBytes();

          os.write(data);
          os.flush();
          os.close();
        
    }

}
