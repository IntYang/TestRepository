package ch11.exam14;
//2017.04.05 수업 내용
public class WrapperExample {
	public static void main(String[] args) {
		int v1 = 10; // 정석적인 문법
	
		Integer v2 = 10; // 10을 갖고 있는 인티저 객체를 대입한다. // 자동 박싱
		
		int v3 = v2; // v2가 갖고있는 내부의 10을 v3에 대입한다 // 자동 언박싱
		
		method1(3); // 자동 박싱
		int v4 = method2(); // 자동 언박싱
		
	
	}
	
	public static void method1(Integer obj){
		//public static void method1(Object obj) 도 가능
	}
	
	public static Integer method2(){
		return 1;
	}
}
