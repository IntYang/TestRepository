package ch09.exam03;
//2017. 04. 03 수업 내용
public class A {
	// field
	static int aField;

	// Constructor
	A() { 
//		final int localVariable = 2; // 1.7버전까지는 문법적으로 무조건 final 붙여야 함
		//** 로컬변수가 로컬클래스 내에서 쓸 때는 자동적으로 final 특성을 가진다. **
		// 왜 final 특성을 갖고 있는가? : 변수라는 것은 스택에 생성됨. 스택에 생성되면 해당 블록 끝나면 없어짐. 
		//로컬변수 끝났다고 해서 안에 있는 D클래스는 힙에서 생성되서 사용되어야 하기 때문에
		//밑에 블록에서 사용되려면 살아있어야 하기 때문에 스택 말고 final 해서 복사해놓음, 복사해놓을 때 값 그대로 유지되어여 하기 때문에 final임
		//final 붙이면 2번 위치에 복사됨(컴파일러가 자동적으로)
		 int localVariable = 2;  // 1.8에서는 안붙여도 final 타입
//		 localVariable = 3; // 이건 불가능
	
		// local class
				class D {
					// field
					int localVariable = 2; //1번
					// constructor
					// method
					void dMethod() {// 자바는 블록 단위의 변수가 있다.
					
						int localVariable = 2;//2번
						int result = localVariable + 8; // 앞에 final에서 값 안주면 오류남
						localVariable = 10; // final에서 값이 들어가서 값 변경 불가
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
