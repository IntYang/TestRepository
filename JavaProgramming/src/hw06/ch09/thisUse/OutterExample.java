package hw06.ch09.thisUse;

public class OutterExample {
	public static void main(String[] args) {
		Outter outter = new Outter();
		Outter.Nested nested = outter.new Nested(); // ��øŬ������ ��ü�� �ٱ� Ŭ���� ��ü ���ļ�
		nested.print();
	}
}
