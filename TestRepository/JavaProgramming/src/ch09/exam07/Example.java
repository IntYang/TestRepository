package ch09.exam07;
//2017. 04. 03 수업 내용
public class Example{

	
	public static void main(String[] args) {
		/*//local class 를 정의하고 객체 생성
		class B2 extends A.B{ // 상속
			@Override
			void bMethod() { // 메소드 재정의
				System.out.println("B2 - bMethod()");
			}
		}
		
//		B2 b2 = new B2(); // 객체 생성
		A.B b = new B2(); // 객체 생성
		b.bMethod(); // 재정의된 객체 메소드 실행
*/	
	//위에 내용 간단하게 작성하기
		
		A.B b = new A.B(){
			@Override
			void bMethod() {
				System.out.println("B2 - bMethod()");
			}
		}; // 생성자 호출하면서 중괄호
		// 해석: 객체를 만드는데, B라는 놈을 상속해서, 상속하고 나서 자식 쪽에서 재정의할 내용을 {}에 써서, 자식 객체를 생성하겠다.
		// == B의 자식 객체를 만들고, {}안에 자식 객체의 재정의 내용이 나온다고 해석
		// => 이름이 없다 해서 "익명객체"
		b.bMethod();
	}

}
