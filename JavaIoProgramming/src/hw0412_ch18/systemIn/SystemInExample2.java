package hw0412_ch18.systemIn;

import java.io.IOException;
import java.io.InputStream;

public class SystemInExample2 {
	public static void main(String[] args) throws IOException {
		InputStream is = System.in; // 콘솔로 입력 스트림을 받는다.
		
		byte[] datas = new byte[100]; // 한 번에 받아올 바이트 수만큼 배열을 생성한다.
		
		System.out.print("이름: ");
		int nameBytes = is.read(datas); // 예외 처리를 해주지 않으면 오류다. datas배열을 읽어온 수 만큼 nameBytes에 저장해
		String name = new String(datas, 0, nameBytes-2); // data에서 0 인덱스부터 nameBytes가 읽은 바이트 만큼 String 객체의 name에 넣어준다.
														// 캐리지리턴 및 라인 피드를 없애기 위해, nameBytes -2를 하는 것이다.
		System.out.print("할 말: ");
		int commandBytes = is.read(datas); // datas배열에서 읽어 온 문자 수 만큼 commandBytes에 저장해
		String command = new String(datas, 0 ,commandBytes-2); // data에서 0 인덱스부터 commandBytes가 읽은 바이트 만큼 String 객체의 commandgw에 넣어준다.
		// 캐리지리턴 및 라인 피드를 없애기 위해, nameBytes -2를 하는 것이다.
		
		System.out.println("입력한 이름: " + name);
		System.out.println("하고 싶은 말: " + command);
	
	
	}
}
