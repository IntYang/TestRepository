package hw0412_ch18.file;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
	public static void main(String[] args) throws Exception{
		File dir = new File("C:/aaaaa/Dir"); // C:/aaaaa 디렉토리 에 Dir 디렉토리 생성
		File file1 = new File("C:/aaaaa/file1.txt");// C:/aaaaa 디렉토리 에 file1.txt 파일 생성
		File file2 = new File("C:/aaaaa/file2.txt");
		File file3 = new File(new URI("file:///C:/aaaaa/file3.txt")); // 파일 경로를 URI객체로 생성하여 매개값으로 제공하여 생성하는 방법 
		
		if(dir.exists() == false)
			dir.mkdirs(); // 디렉토리 안 존재하면, 경로상에 없는 모든 디렉토리 생성해줌
		if(file1.exists() == false)
			file1.createNewFile(); // file1 존재 안하면,file1 파일 새로 생성해줌.
		if(file2.exists() == false)
			file2.createNewFile(); // file2 존재 안하면,file2 파일 새로 생성해줌.
		if(file3.exists() == false)
			file3.createNewFile(); // file3 존재 안하면,file3 파일 새로 생성해줌.
		
		
		File temp = new File("C:/aaaaa"); // temp 에 C:/aaaaa 경로에서 새 파일을 생성하겠다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  a  HH:mm"); // sdf 객체는 yyyy-MM-dd  a  HH:mm 형식으로 날짜 형식을 생성한다
		File[] contents = temp.listFiles(); // File 객체 배열의 contents에는 temp에 저장된 디렉토리에 있는 파일 및 서브 디렉톨 목록 전부를 넣겠다.
		
		
		
		
		System.out.println("날짜                              시간                      형태             크기      이름");
		System.out.println("------------------------------------------------");
		for(File file : contents){ // file 안에서 contents까지 반복
			System.out.println(sdf.format(new Date(file.lastModified()))); // 마지막 수정 날짜 및 시간을 리턴한 값을 새로 Date 객체로 생성하여 format에 넣는다
			if(file.isDirectory()) // 존재하는 디렉토리 이면
				System.out.println("\t<DIR>\t\t\t" + file.getName()); // 파일의 입력 출력
			else //없는 디렉토리면 -> 개별 파일 들은 디렉토리 안에 속해있는게 아니라 개별적으로 존재하니까, 사이즈랑 이름만 주루룩 나옴.
				System.out.println("\t\t\t" + file.length() + "\t" + file.getName()); // 파일의 크기와, 파일의 이름을 출려한다
		
		}
		System.out.println();
	}
}
