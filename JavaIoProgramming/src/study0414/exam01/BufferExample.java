

package study0414.exam01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BufferExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
       //1 . 상대 경로에서 test.txt 파일을 받아오는 코드 작성 
        String path =  BufferExample.class.getResource("test.txt").getPath();
        
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        
        //int readData = -1;
        String readline = null; 
     
        
// 2. 파일을 라인 단위로 읽어오는 코드 작성
        
        while(true){
           readline = br.readLine();
           if(readline == null)
               break;
          
          System.out.println(readline);
          
          // 3. String 배열로, readline으로 받은 내용을 .으로 구분하여 Arrays 배열로 출력하세요.
          String[] text = readline.split(".");
          System.out.println("구분자로 구분한 내용을 배열로 출력> " + Arrays.toString(text)); 
        }
        
        
        br.close();
     
    }
}
