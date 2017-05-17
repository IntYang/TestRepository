package ch18.exam08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
//2017.04.12 수업 내용
// import : ctrl + shift + i
public class WriteExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Reader reader = new FileReader("src/ch18/exam09/test.txt");
        Writer writer = new FileWriter("src/ch18/exam09/test2.txt");
        
        char c1 = '가';
        writer.write(c1);
        
        char[] c2 = {'나', '다', '라'};
        writer.write(c2);
        writer.write(c2,0,2);
        writer.write("마바사아");
        
        writer.flush();
        writer.close();
    }

}
