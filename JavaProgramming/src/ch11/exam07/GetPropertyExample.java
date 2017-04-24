package ch11.exam07;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {

	public static void main(String[] args) {
		
		
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		
		/* Properties props = System.getProperties();
		
		Set keys = props.keySet();
		for(Object objKey : keys){
			String key = (String) objKey; // 강제 타입 변환 
			String value = System.getProperty(key);
			System.out.println("[" + key + "] " + value); 
			
		}*/
		String value = System.getenvUserNmame);
		s
		Set keys = props.keySet();
		for(Object objKey : keys){
			String key = (String) objKey; // 강제 타입 변환 
			String value = System.getProperty(key);
			System.out.println("[" + key + "] " + value); 
	
	
	}

}
