package ch14.exam07;
import java.util.function.BiConsumer;
//2017.04.10 ���� ����
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
		// �͸� ��ü�� �ۼ�
		method1(s -> System.out.println("����"+ s));
		
		method2((a,b)-> System.out.println(a + "-" + b));
		
		method3((a,b)-> {for(int i=0;i<b;i++){ 
						System.out.println(a);}
		});
	}
	
	public static void method1(Consumer<String> arg){
		arg.accept("Java"); // �� �����͸� ��� �Һ��� ���ΰ� �����Ϸ��� Consumer ��ü �����ؾ�..
	}
	public static void method2(BiConsumer<String, String> arg){
		arg.accept("Iot", "Java");
	}
	public static void method3(ObjIntConsumer<String> arg){
		arg.accept("ȫ�浿", 3);
	}
}
