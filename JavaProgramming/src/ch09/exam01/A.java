package ch09.exam01;

public class A {
	// field
	static int aField;

	// Constructor
	A() {
		// local class
		class D {
			// field
			// constructor
			// method
			void dMethod() {// 자바는 블록 단위의 변수가 있다.
				aField = 10;
			}
		}
	}

	// Method
	void aMethod(){
		//local class
		class E{
			//field
			//constructor
			//method
			void eMethod(){// 자바는 블록 단위의 변수가 있다.
				aField = 10; 
		} 
	}
	
	//Nested Class, 중첩 멤버 클래스
	class B{
		//field
		//constructor
		//method
		void bMethod(){// 자바는 블록 단위의 변수가 있다.
			aField = 10; 	
	
	} 
	}
	static class C{
		//field
		//constructor
		//method
		void cMethod(){// 자바는 블록 단위의 변수가 있다.
//			aField = 10;  // A 객체가있어야 가능
			aField = 10;
		
			
		} 
	}
	
	}
}
