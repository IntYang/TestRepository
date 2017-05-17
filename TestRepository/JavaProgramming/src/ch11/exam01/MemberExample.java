package ch11.exam01;
//2017.04.04 수업내용

public class MemberExample {
	public static void main(String[] args) {
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2)); // equals() 메소드 쓸 수 있는 이유: Object를 상속 안해도 상속되있다.
				
		String s1 = "abc";
		String s2 = new String("abc");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
				
	}
}
