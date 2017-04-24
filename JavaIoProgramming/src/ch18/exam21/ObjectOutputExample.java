
package ch18.exam21;

import ch18.exam20.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("src/ch18/exam20/object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        Member member = new Member("김자바", 30); // 이 객체를 위의 파일에 저장하고 싶다
        oos.writeObject(member); //  직렬화할 수 있는 객체 와야함
        
        
        
        
        
        
        oos.flush();
        fos.flush();
        
        oos.close();
        fos.close();
               
    }
}
