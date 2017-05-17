
package ch18.exam16;
//2017.04.13 수업 내용
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

//보조 스트림 여러 개 달린 예제
public class BufferedExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        byte[] data = "가나다".getBytes();
        
        OutputStream os = new FileOutputStream("src/ch18/exam15/test.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os); // 보조 스트림 2개 달기
        BufferedWriter bw = new BufferedWriter(osw);
        
        
        for(int i=0;i<1000;i++){
            bw.write("가나다");
        }
    
        
        
        //프로그램과 가까운 순서대로
        
        bw.flush();
        osw.flush();
        os.flush();
        
        //프로그램과 가까운 순서대로
    
        bw.close();
        osw.close();
        os.close();
    
    }
}
