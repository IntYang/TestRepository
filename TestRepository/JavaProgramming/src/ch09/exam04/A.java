package ch09.exam04;
//2017. 04. 03 ���� ����
public class A {
	//field
	int field; //1��
	//Constructor
	//method
	//��ø���Ŭ����
	
	class B{
		//field
		int field; //2��
		//Constructor
		//method
		void method(){
			field = 10; // == this.field = 10; -> 2��
			A.this.field = 10; // 1�� , A��ü �ʵ��� ���� , �ȵ���̵忡�� ����������
		}
	} 
	
	
}
