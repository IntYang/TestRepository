package ch14.exam03;
//2017.04.10 ���� ����


public class LambdaExperessionExample {
	public static int a = 5;
	
	public static void main(String[] args) {
		method1(()->{
			a = 8 ; // �ʵ�� �� ���� ���� **
			System.out.println(a);});
		int b = 5; //���ú��� , ��� final int b = 5;
		method1(()->{
			//b = 8 ; // ���ú��� �� ���� �Ұ��� -> final ���� Ư¡ **
			while(true){
				System.out.println(b);
				}
			}
		);
	}

	public static void method1(FunctionalInterface1 i) {
		i.method();
	}
	
	
	
}
