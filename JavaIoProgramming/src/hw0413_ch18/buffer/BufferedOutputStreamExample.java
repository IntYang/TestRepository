package hw0413_ch18.buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamExample {
	public static void main(String[] args) throws Exception{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
	// 그냥 스트림. 버퍼 스트림들 입출력용 생성. 속도 차이를 알아보기 위함
		
		int data = -1; // 읽어들이는 데이터 값 저장하는 필드, 초기값은 -1
		long start = 0; long end =0; // 시작, 끝 시간 측정하기 위한 필드
		
		fis = new FileInputStream("C:\\Users\\suyang\\Pictures\\CAM02652.jpg"); // 파일입력스트림으로 해당경로의 이미지 파일을 읽음.
		bis = new BufferedInputStream(fis); // 보조스트림인 버퍼입력 스트림으로 파일 입력스트림에서 읽은 것을 가져옴
		fos = new FileOutputStream("C:\\Users\\suyang\\Pictures\\CAM02652NOTBUFFER.jpg");
		// 파일 출력스트림으로, 해당경로의 파일을 쓸 것
		
		start = System.currentTimeMillis(); // 현재 시작 시간 측정
		System.out.println("시이작: " + start);
		
		while((data = fis.read()) !=-1){ // 파일을 다 읽을 때까지
			fos.write(data);	// data만큼 파일 내용을 fos에 쓴다.
		}
		
		fos.flush(); // 출력 버퍼에 있는 것 다 보내버리기
		end = System.currentTimeMillis(); // 측정 종료 시점
		System.out.println("끝!: " + end);

		System.out.println("버퍼 노 사용: " + (end-start));
		
		fos.close(); // 파일 출력 스트림 닫는다/
		bis.close(); // 버퍼 입력 스트림 닫는다
		fis.close(); // 파일 입력 스트림 닫는다
		// 프로그램과 인접한 순서대로 닫아줘야한다
		
		//---------------------------------------------
		// 이제부터는 버퍼 쓰면 얼마나 빨라지는지 봐야함
		
		fis = new FileInputStream("C:\\Users\\suyang\\Pictures\\CAM02652.jpg");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("C:\\Users\\suyang\\Pictures\\CAM02652BUFFER.jpg");
		bos = new BufferedOutputStream(fos);
		
		start = System.currentTimeMillis();
		System.out.println("시이작: " + start);
		while((data =bis.read()) != -1){
			bos.write(data);
		}
		
		bos.flush();
		end = System.currentTimeMillis();
		System.out.println("끝!: " + end);

		bos.close();
		fos.close();
		bis.close();
		fis.close();
	
		System.out.println("버퍼 사용: " + (end-start));
		
		
//		fos.flush();
		
		
		
		
		
		
	
	
	
	}
}
