
package study0414.exam02;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
     
        FileOutputStream fos = new FileOutputStream("src\\study0414\\exam02\\object.dat"); //경로는 패키지에 맞게 알아서 수정하세요...
      
        // 객체 출력 스트림을 생성하세요. 
      
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        //VVIP 객체 필드의 값은 다음과 같습니다. 필드 값에 맞게 VVIP 객체를 생성하세요.(1줄)
        // 객체 필드 값: memberShipNo == 2, grade == 'C+', name == '김설현', age == 24 
        VVIP vvip = new VVIP(2,"C+", "김설현", 24);
               
        // 객체를 직렬화할 수 있는 실행문을 작성하세요.(1줄)
        oos.writeObject(vvip);
        
        // 객체출력스트림에 잔류하는 모든 문자열을 출력해주세요.(1줄)
        oos.flush();
        fos.flush();
        
        oos.close();
        fos.close();
               
    }
}
