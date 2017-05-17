package hw0411_ch15.hashTable;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExample {
	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("spring", "12");
		map.put("sumemer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("아이디 비번 입력: ");
			System.out.print("아이디: ");
			String id = scanner.nextLine();
			
			System.out.print("비번: ");
			String pw = scanner.nextLine();
			
			if(map.containsKey(id)){
				if(map.get(id).equals(pw)){
					System.out.println("login successed");
					break;
				}
				else
					System.out.println("pw not correct");
					
			}
			else
				System.out.println("id not exist");
		}
		
		
		
	}
}
