package ch14.exam05;
//2017.04.10 ���� ����
public class MethodReferenceExample {
	public static void main(String[] args) {
	/*	method1(new FunctionalInterface1() {
			
			@Override
			public boolean method(String a, String b) {
				// TODO Auto-generated method stub
				return a.equals(b);
			}
		});*/
		method1((a,b)-> a.equals(b)); // �� ���� �Ű����� �״�� ���� �ʱ� ������ �ϳ��� �޼ҵ� ȣ��, �ϳ��� �Ű���
		method1(String :: equals); // �޼ҵ尡 ������ ���� �ΰ��� �� �Ű������� ������ 
								   // �ν��Ͻ���� ���� �ް�����. ���� �Ű������� �ؼ���
		
	}
	
	public static void method1(FunctionalInterface1 i){
		boolean result = i.method("java","Java");
		System.out.println("result: " + result);
	}
}
