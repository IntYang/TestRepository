package ch14.exam02;
//2017.04.10 수업 내용

// 주제: 람다식의 코드 절감.

public class LambdaExperessionExample {

	public static void main(String[] args) {
		method1(() -> System.out.println("run...")	); // 매개변수 없을 때
	
		method2(a->System.out.println(a + " run...")); //  매개변수 1개 일 때
		
		method3((a,b)->System.out.println(a + b)); //  매개변수 2개 일 때
		
		method4((a,b)->a+b); //리턴값이 있을 때 (return a+b -> return 생략 가능)
	
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
