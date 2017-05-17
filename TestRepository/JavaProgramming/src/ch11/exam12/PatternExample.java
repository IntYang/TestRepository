package ch11.exam12;
//2017.04.05 ���� ����
import java.util.regex.Pattern;

public class PatternExample {
	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\{4}";
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		if(result)
			System.out.println("���Խİ� ��ġ�մϴ�.");
		else
			System.out.println("���Խİ� ����ġ�մϴ�.");
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+?)";
		data = "angel@naver.com";
		result = Pattern.matches(regExp, data);
		
		if(result)
			System.out.println("���Խİ� ��ġ�մϴ�.");
		else
			System.out.println("���Խİ� ����ġ�մϴ�.");
		
		
	}
}
