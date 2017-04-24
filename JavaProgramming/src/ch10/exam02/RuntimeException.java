package ch10.exam02;
//2017. 04. 03 수업 내용
import java.util.Scanner;

public class RuntimeException {
	public static void main(String[] args) {

		try { // 예외 발생 가능 코드
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) { // NullPointerException 객체 생성
			System.out.println(e.getMessage()); // 객체가갖고 있는 getMessage()가 에러의
												// 원인을 문자열로 리턴
		} finally { // 항상 실행
			System.out.println("정상적으로 실행되도록 함");
		}

		Scanner scanner = new Scanner(System.in); // 키보드로 부터 문자열 읽어내겠다
		while (true) { // 무한 루프
			System.out.print("입력: ");
			String strNum = scanner.nextLine();
			try {
				int num = Integer.parseInt(strNum);
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력");
			}

		}

	}
}
