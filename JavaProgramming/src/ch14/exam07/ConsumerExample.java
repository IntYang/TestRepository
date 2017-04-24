package ch14.exam07;
import java.util.function.BiConsumer;
//2017.04.10 수업 내용
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {
	public static void main(String[] args) {
		method1(new Consumer<String>(){
			@Override
			public void accept(String t) {
				
					System.out.println(t);
			}
		});
		// 익명 객체로 작성
		method1(s -> System.out.println("과목"+ s));
		
		method2((a,b)-> System.out.println(a + "-" + b));
		
		method3((a,b)-> {for(int i=0;i<b;i++){ 
						System.out.println(a);}
		});
	}
	
	public static void method1(Consumer<String> arg){
		arg.accept("Java"); // 이 데이터를 어떻게 소비할 것인가 정의하려면 Consumer 객체 정의해야..
	}
	public static void method2(BiConsumer<String, String> arg){
		arg.accept("Iot", "Java");
	}
	public static void method3(ObjIntConsumer<String> arg){
		arg.accept("홍길동", 3);
	}
}
