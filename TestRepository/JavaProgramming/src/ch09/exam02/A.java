package ch09.exam02;
//2017. 04. 03 수업 내용
public class A {
	//field
	//Constructor
	A(){ 
		//local class
		class D{} // A 생성자가 끝날 때까지 사용 가능, 잘 안씀, 메소드 많을 때 블록 단위로 만들어 메소드 안에서만 사용하고 싶을 때
	}
	//Method
	void method(){
		//local class
		class E{} // method() 끝날 때까지 사용 가능, 잘 안씀
	}
	
	//Nested Class, 중첩 멤버 클래스
	class B{} // A 객체 없이는 class B 접근 불가능, "인스턴스 멤버 클래스" , A에 종속
	static class C{} // A 객체 없어도 class A로써 접근 가능, "정적 멤버 클래스" , A와 밀접한 관련
	
}
//설계도는 컴파일 하게 되면 하나의 파일로 만들어짐.
//A.class 안에 있는 클래스들도 파일로 만들어짐
// 클래스이름$클래스이름 -> 앞에있는 클래스의 멤버 클래스 or 로컬클래스