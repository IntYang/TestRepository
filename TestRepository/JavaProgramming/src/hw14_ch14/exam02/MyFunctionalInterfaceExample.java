package hw14_ch14.exam02;

public class MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		
		//람다식 생략 형태
		fi = (x) -> { int result = x*5; System.out.println(result);};
		fi.method(2);
		
		fi = (x) -> { System.out.println(5*x);}; // 실행문이 한 개일 때에는 중괄호 {} 생략 가능
		fi.method(2);
		 
		fi = x -> System.out.println(x*5); // 매개변수가 한 개 일 때에는 소괄호 () 생략 가능
		fi.method(2);
	}
}
