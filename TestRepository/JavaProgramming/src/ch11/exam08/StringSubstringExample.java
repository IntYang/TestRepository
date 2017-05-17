package ch11.exam08;

public class StringSubstringExample {
	public static void main(String[] args) {
		String ssn = "920911-2635987";
		
		String firstNum = ssn.substring(0, 6); // 시작~끝
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7); // 주어진 문자열부터 끝까지
		System.out.println(secondNum);
		
		
	}
}
