package ch11.exam14;
//2017.04.05 ���� ����
public class WrapperExample {
	public static void main(String[] args) {
		int v1 = 10; // �������� ����
	
		Integer v2 = 10; // 10�� ���� �ִ� ��Ƽ�� ��ü�� �����Ѵ�. // �ڵ� �ڽ�
		
		int v3 = v2; // v2�� �����ִ� ������ 10�� v3�� �����Ѵ� // �ڵ� ��ڽ�
		
		method1(3); // �ڵ� �ڽ�
		int v4 = method2(); // �ڵ� ��ڽ�
		
	
	}
	
	public static void method1(Integer obj){
		//public static void method1(Object obj) �� ����
	}
	
	public static Integer method2(){
		return 1;
	}
}
