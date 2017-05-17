package ch15.exam05;
//2017.04.11 수업 내용
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args)throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		String path = PropertiesExample.class.getResource("database.properties").getPath(); 
		// 현재 이 클래스가 속해 있는 패키지에서 파일 경로 찾아라 
		// getPath() : 전체 경로 얻어다오
		// 상대 경로로 찾아갈 때 쓰는 방법
		// 다른 패키지에 있는 파일도 가능
		// 절대 경로가 엄청나게 길고 복잡하니까 이렇게 쓴다.
		prop.load(new FileReader(path));
		
		String driver = prop.getProperty("driver");
		System.out.println(driver);
		
		String manager = prop.getProperty("manager");
		System.out.println(manager);
	}
}
