package ch14.exam04;
//2017.04.10 ���� ����
public class MethodReferenceExample {
	public static void main(String[] args) {
		
		
		// �͸� ��ü�� ����
		method1(new FunctionalInterface1() {
			
			@Override
			public int method(int a, int b) {
				// TODO Auto-generated method stub
				return Math.max(a, b);
			}
		});
		method1((a,b)->{return Math.max(a, b);});
//		method1(Math :: max); // �޼ҵ� ����. �Ű����� ���� ������ ����
		
//		method1(Math :: min); // ������
		
		
		
		method1(new Calculator(){
			
			return Calculator.staticSum(a,b);}
		);
		
		
//		method1((a,b)->Calculator.staticSum(a,b));
		method1(Calculator :: staticSum);
		
//		method1((a,b)->Calculator.staticMulti(a, b));
		method1(Calculator :: staticMulti);
		
		Calculator calc = new Calculator();
		method1((a,b)-> calc.minus(a,b));
		
		
	}
	
	public static void method1(FunctionalInterface1 i){
		int result = i.method(3,5);
		System.out.println("result: " + result);
	}
}
