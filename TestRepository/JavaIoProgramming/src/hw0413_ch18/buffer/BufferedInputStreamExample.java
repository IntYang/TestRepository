package hw0413_ch18.buffer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class BufferedInputStreamExample {
	public static void main(String[] args) throws Exception {
		long start = 0; // 시작 시간 초기값
		long end = 0; // 끝 시간 초기값
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\suyang\\Pictures\\CAM02652.jpg"); //해당 경로 사진 읽어들인다
		start = System.currentTimeMillis(); // 시작 시간 측정 시점
		System.out.println(start); // 시작 시간 얼마였는지 볼라고
		while(fis1.read() != -1){ // 파일 읽어들이는 작업 시행
			
		}
		end = System.currentTimeMillis(); // 끝 시간 측정 시점
		System.out.println(end); // 끝 시간 얼마였는지 볼라고
		System.out.println("사용 안 했을 때: " + (end - start)); // 버퍼 사용 안했을 때, 시간
		fis1.close(); // 사용 다했으면 입력 스트림 닫아줌
		
		FileInputStream fis2 = new FileInputStream("C:\\Users\\suyang\\Pictures\\CAM02652.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		//보조 버퍼인 버퍼인풋스트림을 달아준다.
		start = System.currentTimeMillis();
		System.out.println(start);
		while(bis.read() !=-1){
			
		}
		end = System.currentTimeMillis(); // 끝 시간 측정 시점
		System.out.println(end);
		System.out.println("사용했을 때: " + (end - start));
		bis.close();
		fis2.close();
	}
}
