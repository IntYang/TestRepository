
package ch18.exam22;

import java.io.Serializable;

public class Member implements Serializable {
    //Field
    private static final long serialVersionUID = 1; 
    private String mname;
    private int age;
     private String job; 
// 필드 하나 추가되면 에러남
// 클래스 구조가 다르기 때문에 공유 다르다고 생각함
// 겹치는 부분 값 복원시키고 싶을 때?
// 같은 객체냐 다른 객체냐 판별하기 위해 필드에     



//Constructor
    public Member(String mname, int age) {
        this.mname = mname;
        this.age = age;
    }


    //Method
    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    

    
}
