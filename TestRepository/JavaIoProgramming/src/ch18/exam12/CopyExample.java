package ch18.exam12;

// 사진 복사

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//2017.04.12 tndjq sodyd
// 이미지 복사
public class CopyExample {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        InputStream fis = new FileInputStream("src\\ch18\\exam12\\Penguins.jpg");
        OutputStream fos = new FileOutputStream("src\\ch18\\exam12\\Penguins2.jpg");
        
        byte[] data = new byte[1024];  // 한 번에 얼마만큼 읽어 들을 것인가
        int readBytes = -1; // while문 종료 조건
        
        while(true){
            readBytes = fis.read(data); // 파일을 읽어 들인 크기
            if(readBytes == -1) // 더 이상 읽을 파일이 없을 경우
                break; // 종료하여라
            fos.write(data,0,readBytes); // 읽을 바이트보다 남은 바이트가 적을 때 처리방법
            
        }
        
        
        fos.flush();
        fos.close();
        fis.close();
        
        
        
    }
}
