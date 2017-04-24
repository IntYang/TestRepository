package ch11.exam13;
//2017.04.05 수업 내용
// 내림차순 정렬
// 오름차순 정렬

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class SortExample {
	public static void main(String[] args) {
		String[] names = { "홍길동", "김민수", "박동수" };
		
		//System.out.println(names[1]); 
		System.out.println(Arrays.toString(names)); 
		
		//올림차순으로 정렬
		Arrays.sort(names);
		System.out.println(Arrays.toString(names)); 
	
		//내림차순으로 정렬
		Arrays.sort(names, Collections.reverseOrder());
		System.out.println(Arrays.toString(names)); 
		
		
		Member[] members = {
				new Member("홍길동", 20),
				new Member("김민수", 15),
				new Member("박동수", 25)
		};
		// Comparable 타입으로 변환하여 비교해야 하기 때문에, Comparable 인터페이스를 구현해야 한다.
				
		//Member 객체를 이름순으로 정렬하시오.[문제]
		System.out.println("[Member]");
		System.out.println(Arrays.toString(members)); 
		// 클래스이름@해시코드로 나오므로, toString에 대한 재정의가 필요하다.
		
		//올림차순 출력
		Arrays.sort(members);
		System.out.println(Arrays.toString(members)); 
		//Comparable com = new Member("홍길동"); -> 클래스라면 상속해야 가능, 인터페이스라면 구현해야 봄
		
		//내림차순 정렬
		Arrays.sort(members, Collections.reverseOrder());
		System.out.println(Arrays.toString(members));
	}
}
