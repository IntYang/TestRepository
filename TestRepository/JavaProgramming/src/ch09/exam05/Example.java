package ch09.exam05;

public class Example {

	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B(); // a�� ��ü�� ���� B�� �����ؾ� �Ѵ� , B�� �ν��Ͻ�
		
		A.C c = new A.C();  // A Ŭ���� ���� C�� ���� // A.C : A Ŭ������ �ִ� C���� // ���� �����
	}

}
