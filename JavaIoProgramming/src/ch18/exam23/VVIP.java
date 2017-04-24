
package ch18.exam23;

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
    
    // 부모가 직렬화 안했을 때, 부모꺼 직렬화 안됬음
    // 밑의 두 메소드를 통해 부모꺼 직접 직렬화(부모 필드에 있는 것들 직접 직렬화 시켜주는 코드
    // 자식 클래스에만 있는 필든,ㄴ defaultWriteObject 통해 직렬화 됨
    // 접근 제한자는 반드시 private로 저장해야 함
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.writeUTF(getName()); 
        out.writeInt(getAge());
        out.defaultWriteObject(); // 자기 자신의 필드를 직렬화해라 , grade는 여기서 직렬화됨
    }
    
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException {
        setName(in.readUTF()); // 문자열을 읽고  부모의 Name에 세팅
        setAge(in.readInt()); // 인트 읽고 부모의 
        in.defaultReadObject(); // 자신의 필드를 역직렬화
    
    
    }
    
    
}
