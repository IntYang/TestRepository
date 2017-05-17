package hw0413_ch18.OutputStreamWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterExample {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("src/hw0413_ch18/OutputStreamWriter/test.txt"); 
		//FileOutputStream 객체 fos에 해당 경로에 바이트 기반으로 데이터를 저장할 것이다. 
		Writer writer = new OutputStreamWriter(fos);
		// Writer라는 보조 스트림을 달아, 바이트 기반 -> 문자 기반으로 변환하여 저장하게끔 해준다.
		
		String data = "바이트 출력 스트림을 문자 출력 스트림으로";
		writer.write(data); // data의 String형을 writer 보조 스트림에 쓴다.
		
		writer.flush(); // ㅓ버퍼 안에 있는 내용 모두 가랏
		writer.close(); // 파일 닫아준다.
		
		
		
	}
}
