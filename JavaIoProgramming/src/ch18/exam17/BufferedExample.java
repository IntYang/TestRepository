
package ch18.exam17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class BufferedExample {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        String line = br.readLine(); // 쌓아 놓았다가 라인 단위로 왕창 읽는다.
        System.out.println(line);
        
        
        
        br.close();
        isr.close();
        is.close();
        
    }
}
