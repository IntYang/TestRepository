
package study0414.exam02;

import ch18.exam23.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class VVIP extends Person implements Serializable{
    private int memberShipNo;
    private String grade; // 자식 추가 필드

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public VVIP(){}
    public VVIP(int memberShipNo, String grade, String name, int age) {
        super(name, age);
        this.memberShipNo = memberShipNo;
        this.grade = grade;
    }

    public int getMemberShipNo() {
        return memberShipNo;
    }

    public void setMemberShipNo(int memberShipNo) {
        this.memberShipNo = memberShipNo;
    }
    
    
    //부모 필드에 추가된 필드를 직렬화하고, 자식 객체의 필드도 직렬화 해주는 메소드를 작성하시오.
    private void writeObject(ObjectOutputStream out) throws IOException{
       out.writeUTF(getName());
       out.writeInt(getAge());
       out.defaultWriteObject();
       
    }
    // 부모 필드에 추가된 필드를 역직렬화하고, 자식 객체으 필드도 역직렬화 해주는 메소드를 작성하시오.
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException {
      setName(in.readUTF());
      setAge(in.readInt());
      in.defaultReadObject();
    
    }
    
    
}
