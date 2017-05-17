package ch15.exam05;
//2017.04.11 ���� ����
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args)throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		String path = PropertiesExample.class.getResource("database.properties").getPath(); 
		// ���� �� Ŭ������ ���� �ִ� ��Ű������ ���� ��� ã�ƶ� 
		// getPath() : ��ü ��� ���ٿ�
		// ��� ��η� ã�ư� �� ���� ���
		// �ٸ� ��Ű���� �ִ� ���ϵ� ����
		// ���� ��ΰ� ��û���� ��� �����ϴϱ� �̷��� ����.
		prop.load(new FileReader(path));
		
		String driver = prop.getProperty("driver");
		System.out.println(driver);
		
		String manager = prop.getProperty("manager");
		System.out.println(manager);
	}
}
