package ch09.exam06;

public class Example implements A.B {

	@Override
	public void method() {
		
	}
	public static void main(String[] args) {
		class C implements A.B{ //�������̽������� �翬�� �żҵ� ������
			@Override
			public void method() {
				
			}
		}
	}

}
