package ch09.exam07;
//2017. 04. 03 ���� ����
public class Example{

	
	public static void main(String[] args) {
		/*//local class �� �����ϰ� ��ü ����
		class B2 extends A.B{ // ���
			@Override
			void bMethod() { // �޼ҵ� ������
				System.out.println("B2 - bMethod()");
			}
		}
		
//		B2 b2 = new B2(); // ��ü ����
		A.B b = new B2(); // ��ü ����
		b.bMethod(); // �����ǵ� ��ü �޼ҵ� ����
*/	
	//���� ���� �����ϰ� �ۼ��ϱ�
		
		A.B b = new A.B(){
			@Override
			void bMethod() {
				System.out.println("B2 - bMethod()");
			}
		}; // ������ ȣ���ϸ鼭 �߰�ȣ
		// �ؼ�: ��ü�� ����µ�, B��� ���� ����ؼ�, ����ϰ� ���� �ڽ� �ʿ��� �������� ������ {}�� �Ἥ, �ڽ� ��ü�� �����ϰڴ�.
		// == B�� �ڽ� ��ü�� �����, {}�ȿ� �ڽ� ��ü�� ������ ������ ���´ٰ� �ؼ�
		// => �̸��� ���� �ؼ� "�͸�ü"
		b.bMethod();
	}

}
