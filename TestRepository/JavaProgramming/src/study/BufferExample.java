package study;





import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
       //1 . 상대 경로에서 test.txt 파일을 받아오는 코드 작성 
        String path =  BufferExample.class.getResource("test.txt").getPath();
        
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        
        int readData = -1;
        // 2. 파일을 라인 단E위로 읽어오는 코드 작성
        
        while(true){
           readData = br.read();
           if(readData == -1)
               break;
          String readLine;
           readLine = br.readLine();
          System.out.println(readLine);
//           String[] dataSplit = data.split("[.]");
//           System.out.println(data +" " + dataSplit.length);
//           
           
        }
        
        
        br.close();
     //   fr.close();
    }
}
