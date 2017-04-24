
package ch18.exam19;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class LineDataExample {
    public static void main(String[] args) throws IOException {
//        FileWriter fw = new FileWriter("src/ch18/exam19/test.txt");
//        FileOutputStream fos = new FileOutputStream("src/ch18/exam19/test.txt");
//        OutputStreamWriter osw = new OutputStreamWriter(fos); //
// 
//        osw.write("abcde\r\n");
//        osw.write("12345\r\n");
//        osw.write("가나다라마");
//        
//        osw.flush();
//        fos.flush();
//        osw.close();
//        fos.close();

// 편리하게 이용하기 위해, PrintStream 쓴다.
          FileOutputStream fos = new FileOutputStream("src/ch18/exam19/test.txt");
          
          PrintStream out = new PrintStream(fos);
          //PrintWriter 써도 상관 없음.
          
          out.println("abcde");
          out.println("12345");
          out.print("가나다라마");
          
          
          out.flush();
          fos.flush();
          
          out.close();
          fos.close();
          
          
          
          
          // 행 단위로 읽어 들이면 BufferedReader
          
          FileInputStream fis = new FileInputStream("src/ch18/exam19/test.txt");
          InputStreamReader isr = new InputStreamReader(fis);
          BufferedReader br = new BufferedReader(isr);


          while(true){ // 파일의 모든 행을 읽어 들이고 싶을 때
              String line = br.readLine();
              if(line == null) //  readLine 더 읽을 것 없으면 null 리턴
                  break;
              System.out.println(line);
              
              
              
              
              
              
          }
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
       
    }
    
    
    
}
