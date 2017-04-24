package ch18.exam09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyExample {
     public static void main(String[] args) throws FileNotFoundException, IOException {
        Reader reader = new FileReader("src/ch18/exam09/test.txt");
        Writer writer = new FileWriter("src/ch18/exam09/test2.txt");
        
        char[] str = new char[4];
        int readChar = -1;
        while(true){
            readChar = reader.read();
            if(readChar == -1) break;
            
            writer.write(str,0,readChar);
        }
        
        writer.flush();
        writer.close();
        reader.close();
    }
}
