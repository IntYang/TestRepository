package ch09.exam05;

public class Example {

	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B(); // a의 객체를 통해 B에 접근해야 한다 , B는 인스턴스
		
		A.C c = new A.C();  // A 클래스 통해 C에 접근 // A.C : A 클래스에 있는 C구나 // 많이 사용함
	}

}
