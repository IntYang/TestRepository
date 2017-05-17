package ch18.exam13;
//2017.04.13 수업 내용
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderExample  {
    public static void main(String[] args) throws IOException {
//        InputStream is = System.in; // 키보드로 입력이 들어 온다. // FileInputStream이면 파일로 입력이 들어오는 것
//        InputStreamReader reader = new InputStreamReader(is);
//// 
////        int data = is.read();
////        System.out.println((char)data);//
////        이렇게 읽으면 한글 깨짐
//          
//       

        InputStream is = new FileInputStream("src\\ch18\\exam13\\test.txt");
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        
        int data = isr.read();
        System.out.println((char)data);
                // 다 깨지는데 원인을 모르겠네


    }
}
