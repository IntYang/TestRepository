package ch14.exam05;
//2017.04.10 수업 내용
public class MethodReferenceExample {
	public static void main(String[] args) {
	/*	method1(new FunctionalInterface1() {
			
			@Override
			public boolean method(String a, String b) {
				// TODO Auto-generated method stub
				return a.equals(b);
			}
		});*/
		method1((a,b)-> a.equals(b)); // 두 개의 매개값이 그대로 들어가지 않기 때문에 하나는 메소드 호출, 하나는 매개값
		method1(String :: equals); // 메소드가 정적일 때는 두개를 다 매개값으로 받지만 
								   // 인스턴스라면 앞의 메개변수. 뒤의 매개값으로 해석함
		
	}
	
	public static void method1(FunctionalInterface1 i){
		boolean result = i.method("java","Java");
		System.out.println("result: " + result);
	}
}
