package ch09.exam07;
//2017. 04. 03 수업 내용
public class Example2{

	
	public static void main(String[] args) {
		
		
		/*//로컬 클래스를 정의하고 객체 생성
		class CImpl implements A.C{
			@Override
			public void cMethod() { // C class 의 메소드 재정의
				System.out.println("CImpl의 메소드 실행");				
			}
		}
		
		CImpl cimpl = new CImpl();
		cimpl.cMethod();
		
		A.C c = new CImpl();
		c.cMethod();
		*/
		
		// 위에 내용 간단하게 구현하기
		
		A.C c = new A.C(){//C가 인터페이스일 경우,  C를 가지고 블록 안에 구현 클래스를 만들어, 객체를 생성한다. => 익명클래스
			@Override
			public void cMethod() {
				System.out.println("CImpl의 메소드 실행");		
			}
		}; // 실행문이기 때문에 세미콜론 생략하면 안됨.
		c.cMethod();
		
	}

}
