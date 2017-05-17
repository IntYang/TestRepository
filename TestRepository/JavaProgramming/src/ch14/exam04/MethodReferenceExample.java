package ch14.exam04;
//2017.04.10 수업 내용
public class MethodReferenceExample {
	public static void main(String[] args) {
		
		
		// 익명 객체로 생성
		method1(new FunctionalInterface1() {
			
			@Override
			public int method(int a, int b) {
				// TODO Auto-generated method stub
				return Math.max(a, b);
			}
		});
		method1((a,b)->{return Math.max(a, b);});
//		method1(Math :: max); // 메소드 참조. 매개값에 대한 정보가 없음
		
//		method1(Math :: min); // 다형성
		
		
		
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
