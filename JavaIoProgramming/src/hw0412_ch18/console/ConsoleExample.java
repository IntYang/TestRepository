package hw0412_ch18.console;

import java.io.Console;

public class ConsoleExample {
	public static void main(String[] args) {
		Console cs = System.console(); // 콘솔로 부터 읽어들임. 처음에 리턴 값 null이므로 명령프롬프트에서 실행해 볼 것.
		
		System.out.print("ID: ");
		String id = cs.readLine(); // id에는 콘솔에서 다음 라인을 읽어들인 내용을 넣는ㄷ.
		
		System.out.print("PW: ");
		char[] charPass = cs.readPassword();//키보드 입력 문자 콘솔에 안보여주고 읽음
		String strPassword = new String(charPass); // String객체의 strPassword에 charPass 배열에 있는 스트링 객체를 새로 생성해 넣는다.
		
		System.out.println("-----------");
		System.out.println(id);
		System.out.println(strPassword);
	}
}
