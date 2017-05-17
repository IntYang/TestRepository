

package study0414.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ObjectInputExample {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src\\study0414\\exam02\\object.dat"); //경로는 패키지에 맞게 알아서 수정하세요...
        
        // 객체입력스트림을 생성하세요.(1줄)
        ObjectInputStream ois = new ObjectInputStream(fis);
       
        // 자식 객체에 있는 내용을 읽어오는 코드를 작성하세요 (1줄)
        
        VVIP vvip = (VVIP)ois.readObject();
        
        // 부모 객체 필드의 값을 읽어오는 출력문 2개 작성(name, age)
        System.out.println(vvip.getName());
        System.out.println(vvip.getAge());
        
        // 자식 객체 필드의 값을 읽어오는 출력문 2개 작성(membershipNo, grade)
       
        System.out.println(vvip.getName());
        System.out.println(vvip.getAge());
        
           
        ois.close();
        fis.close();
        
        
    }

}
