package ch09.exam05;
//2017. 04. 03 수업 내용
public class A {
	//field
	//Constructor
	A(){ 
		//local class
		class D{} 
		D d = new D(); // 로컬 클래스에도 static 못붙임
	}
	//Method
	void method(){
		//local class
		class E{} 
		E e = new E();
	}
	
	//Nested Class, 중첩 멤버 클래스
	class B{} 
	static class C{} 
	
}
