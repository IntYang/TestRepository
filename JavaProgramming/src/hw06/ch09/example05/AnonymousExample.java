package hw06.ch09.example05;

public class AnonymousExample {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method1();
		//인스턴스.매소드(new 객체(){ ///오버라이드 한 메소드들 } );
		anony.method2(new Vehicle(){
			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		});
	}

}
