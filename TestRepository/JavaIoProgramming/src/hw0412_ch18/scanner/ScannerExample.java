package hw0412_ch18.scanner;

import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 스캐너로 입력을 받아온다.
		
		System.out.println("문자열 입력> ");
		String inputString = scanner.nextLine(); //다음 라인을 scanner로 읽어와 inputString에 저장한다. // 라인은 형 관계없이 읽어들일 수 있어서 사용 가능
		System.out.println(inputString); // inputString에 저장된 내용 출력
		System.out.println();
		
		System.out.println("정수 입력> "); // 
		int inputInt = scanner.nextInt(); // scanner로 읽어와 inputInt에 저장한다
		System.out.println(inputInt);
		System.out.println();
		
		System.out.println("실수 입력> ");
		double inputDouble = scanner.nextDouble();
		System.out.println(inputDouble);
		
		
		
	}
}
