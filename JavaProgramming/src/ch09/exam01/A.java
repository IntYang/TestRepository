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
			void dMethod() {// �ڹٴ� ��� ������ ������ �ִ�.
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
			void eMethod(){// �ڹٴ� ��� ������ ������ �ִ�.
				aField = 10; 
		} 
	}
	
	//Nested Class, ��ø ��� Ŭ����
	class B{
		//field
		//constructor
		//method
		void bMethod(){// �ڹٴ� ��� ������ ������ �ִ�.
			aField = 10; 	
	
	} 
	}
	static class C{
		//field
		//constructor
		//method
		void cMethod(){// �ڹٴ� ��� ������ ������ �ִ�.
//			aField = 10;  // A ��ü���־�� ����
			aField = 10;
		
			
		} 
	}
	
	}
}
