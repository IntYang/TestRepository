package ch09.exam03;
//2017. 04. 03 ���� ����
public class A {
	// field
	static int aField;

	// Constructor
	A() { 
//		final int localVariable = 2; // 1.7���������� ���������� ������ final �ٿ��� ��
		//** ���ú����� ����Ŭ���� ������ �� ���� �ڵ������� final Ư���� ������. **
		// �� final Ư���� ���� �ִ°�? : ������� ���� ���ÿ� ������. ���ÿ� �����Ǹ� �ش� ��� ������ ������. 
		//���ú��� �����ٰ� �ؼ� �ȿ� �ִ� DŬ������ ������ �����Ǽ� ���Ǿ�� �ϱ� ������
		//�ؿ� ��Ͽ��� ���Ƿ��� ����־�� �ϱ� ������ ���� ���� final �ؼ� �����س���, �����س��� �� �� �״�� �����Ǿ �ϱ� ������ final��
		//final ���̸� 2�� ��ġ�� �����(�����Ϸ��� �ڵ�������)
		 int localVariable = 2;  // 1.8������ �Ⱥٿ��� final Ÿ��
//		 localVariable = 3; // �̰� �Ұ���
	
		// local class
				class D {
					// field
					int localVariable = 2; //1��
					// constructor
					// method
					void dMethod() {// �ڹٴ� ��� ������ ������ �ִ�.
					
						int localVariable = 2;//2��
						int result = localVariable + 8; // �տ� final���� �� ���ָ� ������
						localVariable = 10; // final���� ���� ���� �� ���� �Ұ�
					}
				}
	
	}
		
	

	// Method
	void aMethod(){
		//local class
		class E{
			//field
			//constructor
			//method
			void eMethod(){// �ڹٴ� ��� ������ ������ �ִ�.
				aField = 10; 
		} 
	}
	
	//Nested Class, ��ø ��� Ŭ����
	class B{
		//field
		//constructor
		//method
		void bMethod(){// �ڹٴ� ��� ������ ������ �ִ�.
			aField = 10; 	
	
	} 
	}
	static class C{
		//field
		//constructor
		//method
		void cMethod(){// �ڹٴ� ��� ������ ������ �ִ�.
//			aField = 10;  // A ��ü���־�� ����
			aField = 10;
		
			
		} 
	}
	
}
