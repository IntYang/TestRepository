package ch09.exam05;
//2017. 04. 03 ���� ����
public class A {
	//field
	//Constructor
	A(){ 
		//local class
		class D{} 
		D d = new D(); // ���� Ŭ�������� static ������
	}
	//Method
	void method(){
		//local class
		class E{} 
		E e = new E();
	}
	
	//Nested Class, ��ø ��� Ŭ����
	class B{} 
	static class C{} 
	
}
