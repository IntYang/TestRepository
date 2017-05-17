package hw14_ch14.exam07;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferenceExample {
	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;
		
		function = (a,b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("java9", "JAVA8"));
		
		function = String :: compareToIgnoreCase;
		print(function.applyAsInt("Java8", "JAVA8"));
		
	}

	public static void print(int order){
		if(order < 0)
			System.out.println("���� ������ ���� �´�");
		else if(order == 0)
			System.out.println("������ ���ڿ�");
		else
			System.out.println("���� ������ ���߿� �´�");
	}



}
