package ch14.exam02;
//2017.04.10 ���� ����

// ����: ���ٽ��� �ڵ� ����.

public class LambdaExperessionExample {

	public static void main(String[] args) {
		method1(() -> System.out.println("run...")	); // �Ű����� ���� ��
	
		method2(a->System.out.println(a + " run...")); //  �Ű����� 1�� �� ��
		
		method3((a,b)->System.out.println(a + b)); //  �Ű����� 2�� �� ��
		
		method4((a,b)->a+b); //���ϰ��� ���� �� (return a+b -> return ���� ����)
	
	}

	public static void method1(FunctionalInterface1 i) {
		i.method();
	}
	public static void method2(FunctionalInterface2 i){
		i.method(3);
	}
	
	public static void method3(FunctionalInterface3 i){
		i.method(3,5);
	}
	
	public static void method4(FunctionalInterface4 i){
		
		int result = i.method(3,5);
		System.out.println("result: " + result);
	}
	
	
}
