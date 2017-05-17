package hw0413_ch18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream is = new FileInputStream("src/hw0413_ch18/Penguins.jpg");
        FileOutputStream os = new FileOutputStream("src/hw0413_ch18/Penguins2.jpg");

        byte[] data = new byte[1024];
	
	// 그림을 복사하는 코드를 입력하세요
        
        int dataBytes = -1;
        while(true){
            dataBytes = is.read(data);
            if(dataBytes == -1)
                break;
            
            os.write(data, 0 ,dataBytes);
            }
        
        os.flush();
        os.close();
        is.close();
        }
        
    }
