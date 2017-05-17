package hw06.ch09.memberClassRestrict;

public class A {
	//인스턴스 변수
	int field1;
	//인스턴스 메소드
	void method1(){}
	
	// 정적 변수 및 메소드
	static int field2;
	static void method2(){}
	
	//인스턴스 멤버 클래스
	class B{
		void method(){ // 모든 필드, 메소드에 접근 가능
			field1 = 10;
			method1();
			
			field2 = 10;
			method2();
		}
	}
	
	//정적 멤버 클래스
	static class C{ // 정적 필드와 메소드만 접근 가능
		void method(){
			field2 = 10;
			method2();
		}
	}
	
	
	
}
