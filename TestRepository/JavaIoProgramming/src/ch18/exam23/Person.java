
package ch18.exam23;

public class Person {
    private String name;
    private int age; // 부모 추가 필드
    
    
    public Person(){
        
    }
    
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
