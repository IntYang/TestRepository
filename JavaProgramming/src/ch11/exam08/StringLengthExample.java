package ch11.exam08;

public class StringLengthExample {
	public static void main(String[] args) {
		String ssn ="7306241230123";
		
		if(ssn.length() == 13){
			System.out.println("주민번호 자릿수 맞음");
		}
		else
			System.out.println("주민번호 자릿수 틀림");
	}
}
