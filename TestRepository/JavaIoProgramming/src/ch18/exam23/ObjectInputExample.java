

package ch18.exam23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

// 실행 순서 : Output -> Input Example 순 : 써야 읽지
public class ObjectInputExample {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/ch18/exam23/object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
       
        VVIP vvip = (VVIP) ois.readObject();
        System.out.println(vvip.getMemberShipNo());
        System.out.println(vvip.getName()); // 부모가 Serailizeable 구현 안했을 때 직렬화 불가능
        System.out.println(vvip.getAge()); // 부모가 Serailizeable 구현 안했을 때 직렬화 불가능
        System.out.println(vvip.getGrade()); // 부모가 Serailizeable 구현 안했을 때 직렬화 불가능
        
        
           
        ois.close();
        fis.close();
        
        
    }

}
