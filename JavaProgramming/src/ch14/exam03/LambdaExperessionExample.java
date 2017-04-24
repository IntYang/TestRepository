package ch14.exam03;
//2017.04.10 수업 내용


public class LambdaExperessionExample {
	public static int a = 5;
	
	public static void main(String[] args) {
		method1(()->{
			a = 8 ; // 필드라서 값 변경 가능 **
			System.out.println(a);});
		int b = 5; //로컬변수 , 사실 final int b = 5;
		method1(()->{
			//b = 8 ; // 로컬변수 값 변경 불가능 -> final 변수 특징 **
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
