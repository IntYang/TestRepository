package hw14_ch14.exam03;

public class MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		
		//람다식 생략 형태
		fi = (x, y) -> { int result = x + y; return result;};
		System.out.println(fi.method(2,5));
		
		
		fi = (x, y) -> { return x+y;};
		System.out.println(fi.method(2,5));
		
		fi = (x, y) -> x+y;// return문만 있을 경우 중괄호 {} 와 return 생략 가능
		System.out.println(fi.method(2,5));
		
		fi = (x, y) -> sum(x,y);// 실행문이 한 개일 때에는 중괄호 {} 생략 가능
		System.out.println(fi.method(2,5));
	}
	
	
	public static int sum(int x , int y){
		return x+y;
	}
}
