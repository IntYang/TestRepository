package hw06.ch09.memberClassRestrict;

public class A {
	//�ν��Ͻ� ����
	int field1;
	//�ν��Ͻ� �޼ҵ�
	void method1(){}
	
	// ���� ���� �� �޼ҵ�
	static int field2;
	static void method2(){}
	
	//�ν��Ͻ� ��� Ŭ����
	class B{
		void method(){ // ��� �ʵ�, �޼ҵ忡 ���� ����
			field1 = 10;
			method1();
			
			field2 = 10;
			method2();
		}
	}
	
	//���� ��� Ŭ����
	static class C{ // ���� �ʵ�� �޼ҵ常 ���� ����
		void method(){
			field2 = 10;
			method2();
		}
	}
	
	
	
}
