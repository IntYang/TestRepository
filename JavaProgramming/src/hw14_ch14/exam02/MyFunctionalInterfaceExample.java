package hw14_ch14.exam02;

public class MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		
		//���ٽ� ���� ����
		fi = (x) -> { int result = x*5; System.out.println(result);};
		fi.method(2);
		
		fi = (x) -> { System.out.println(5*x);}; // ���๮�� �� ���� ������ �߰�ȣ {} ���� ����
		fi.method(2);
		 
		fi = x -> System.out.println(x*5); // �Ű������� �� �� �� ������ �Ұ�ȣ () ���� ����
		fi.method(2);
	}
}
