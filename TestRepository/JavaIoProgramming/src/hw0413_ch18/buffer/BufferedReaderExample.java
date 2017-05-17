package hw0413_ch18.buffer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderExample {
	public static void main(String[] args) throws Exception{
		InputStream is = System.in; // 입력 읽어오는 스트림 
		Reader reader = new InputStreamReader(is); // 스트림: 바이트 -> 문자
		BufferedReader br = new BufferedReader(reader); // Reader에 보조버퍼 달아줌.버퍼 스트림생성
		
		System.out.print("입력: ");
		String line = br.readLine(); // 라인 단위로 한줄 전체를 읽어주는 nextLine()
		
		System.out.println("출력: " + line);
		
		
		
		
	}
}
