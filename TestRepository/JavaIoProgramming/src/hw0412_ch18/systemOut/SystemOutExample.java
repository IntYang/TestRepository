package hw0412_ch18.systemOut;

import java.io.IOException;
import java.io.OutputStream;

public class SystemOutExample {
	public static void main(String[] args) throws IOException{
		OutputStream os = System.out; // 콘솔에 내보내는 outputStream
		
		for(byte b=48; b<58; b++){ // 아스키코드 48부터 57사이의 바이트를 출력하는 반복문
			os.write(b);
		}
		os.write(10); // 라인피드(10) 출력하면 다음 행으로 넘어가게
	
		for(byte b=97; b<123;b++){ // 아스크코드 97부터 123까지 바이트를 출력하는 반복문
			os.write(b);
		}
	
		os.write(10); // 라인피드 출력하면 다음 행으로 넘어감
		
		String hangul ="가나다라마바사아자차카타파하"; // 한글 받는 스트링
		byte[] hBytes = hangul.getBytes(); // byte형 배열 hBytes에 String객체 hangul을 바이트로 받은 것을 저장함
		
		os.write(hBytes); // 콘솔에 hBytes내용 내보냄
		
		os.flush(); // 버퍼로 플러쉬함(버퍼 잔류 모든 문자열 출력)
	}
	
}
