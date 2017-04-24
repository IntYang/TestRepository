package hw0413_ch18.inputStreamReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {
	public static void main(String[] args) throws IOException {
		InputStream is = System.in; // InputStream 객체에 System.in으로 읽어들인 내용을 저장한다. 콘솔에서 한글 읽기 가능
		Reader reader = new InputStreamReader(is); // Reader 객체의 reader에  is에서 받아 온 InputStreamReader을 생성한 것을 넣는다.
		
		int readCharNo = -1; // 한 번에 몇 char씩 읽는지 받는 변수
		
		char[] cbuf = new char[100]; // char 배열 100개짜리를 생성하여, cbuf에 100만큼씩 한 번에 읽어 오기 가능
		/*while((readCharNo = reader.read(cbuf))!=-1){
			String data = new String(cbuf, 0, readCharNo);
			System.out.println(data);
		}*/

		while(true){
			readCharNo = reader.read(cbuf); // cbuf에서 몇 char만큼 읽었는 지 readCharNo에 저장한다.
			if(readCharNo == -1) // 더 이상 읽어들일 내용이 없으면 while문 탈출
				break;
			String data = new String(cbuf, 0, readCharNo); // String형인 data에 cbuf에서 0부터 readCharNo인덱스까지 읽은 스트링형을 저장한다.
			System.out.println(data); // data에 저장한 내용을 출력
		}
		
		reader.close(); // 다 읽었으면, 다다준다.
	
	}
}
