package hw14_ch14.exam04;

public class UsingThisExample {
	public static void main(String[] args) {
		UsingThis usingThis = new UsingThis();
		UsingThis.Inner inner = usingThis.new Inner(); // 로컬 클래스
		inner.method();
	}
}
