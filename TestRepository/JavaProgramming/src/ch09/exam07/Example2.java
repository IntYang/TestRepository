package ch09.exam07;
//2017. 04. 03 ���� ����
public class Example2{

	
	public static void main(String[] args) {
		
		
		/*//���� Ŭ������ �����ϰ� ��ü ����
		class CImpl implements A.C{
			@Override
			public void cMethod() { // C class �� �޼ҵ� ������
				System.out.println("CImpl�� �޼ҵ� ����");				
			}
		}
		
		CImpl cimpl = new CImpl();
		cimpl.cMethod();
		
		A.C c = new CImpl();
		c.cMethod();
		*/
		
		// ���� ���� �����ϰ� �����ϱ�
		
		A.C c = new A.C(){//C�� �������̽��� ���,  C�� ������ ��� �ȿ� ���� Ŭ������ �����, ��ü�� �����Ѵ�. => �͸�Ŭ����
			@Override
			public void cMethod() {
				System.out.println("CImpl�� �޼ҵ� ����");		
			}
		}; // ���๮�̱� ������ �����ݷ� �����ϸ� �ȵ�.
		c.cMethod();
		
	}

}
