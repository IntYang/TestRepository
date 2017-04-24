package ch09.exam06;

public class Example implements A.B {

	@Override
	public void method() {
		
	}
	public static void main(String[] args) {
		class C implements A.B{ //인터페이스에서는 당연히 매소드 재정의
			@Override
			public void method() {
				
			}
		}
	}

}
