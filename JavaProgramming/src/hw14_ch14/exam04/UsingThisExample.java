package hw14_ch14.exam04;

public class UsingThisExample {
	public static void main(String[] args) {
		UsingThis usingThis = new UsingThis();
		UsingThis.Inner inner = usingThis.new Inner(); // ���� Ŭ����
		inner.method();
	}
}
