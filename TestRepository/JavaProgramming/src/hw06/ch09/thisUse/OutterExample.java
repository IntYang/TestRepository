package hw06.ch09.thisUse;

public class OutterExample {
	public static void main(String[] args) {
		Outter outter = new Outter();
		Outter.Nested nested = outter.new Nested(); // 중첩클래스의 객체는 바깥 클래스 객체 거쳐서
		nested.print();
	}
}
