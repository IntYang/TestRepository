package study;





import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
       //1 . ��� ��ο��� test.txt ������ �޾ƿ��� �ڵ� �ۼ� 
        String path =  BufferExample.class.getResource("test.txt").getPath();
        
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        
        int readData = -1;
        // 2. ������ ���� ��E���� �о���� �ڵ� �ۼ�
        
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
