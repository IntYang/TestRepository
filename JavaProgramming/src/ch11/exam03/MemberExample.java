package ch11.exam03;


//2017.04.04 수업내용

public class MemberExample {
	public static void main(String[] args) {
		Member m1 = new Member("blue");
		System.out.println(m1.toString());
		System.out.println(m1);	
		
		String result = m1 + "good"; // + : 문자열 결합
		System.out.println(result);
	}
}
