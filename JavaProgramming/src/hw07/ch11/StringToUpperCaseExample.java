package hw07.ch11;
// 영어로 된 두 문자열을 대소문자 상관없이 비교하고 싶을 때
public class StringToUpperCaseExample {
	public static void main(String[] args) {
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";
		
		System.out.println(str1.equals(str2)); // 재정의 안해도 String 클래스에 논리적 동등 기능 있음
		
		String lowerStr1 = str1.toLowerCase(); //  소문자로 바꾸기
		System.out.println("str1의 변환: "+lowerStr1);
		
		String lowerStr2 = str2.toUpperCase(); // 대문자로 바꾸기
		System.out.println("str2의 변환: "+lowerStr2);
		
		System.out.println(lowerStr1.equals(lowerStr2));
		
		System.out.println(str1.equalsIgnoreCase(str2)); // 대소문자 상관없이 다 똑같이
	}
}
