package ch11.exam02;

import java.util.HashSet;

//2017.04.04 수업내용

public class MemberExample {
	public static void main(String[] args) {
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		
		//hashcode의 계산: 메모리 번지 기준으로 나온 것이므로, 번지가 다르면 해시코드는 다르게 나온다.
		System.out.println(m1.hashCode()); 
		System.out.println(m2.hashCode()); 
		//동등비교를 할 때 해시코드 똑같이 만들어야 할 경우가 있음.
		// HashSet, HaseMap, Hashtable 등의 컬렉션 객체를 사용할 때.
				
		HashSet hashSet = new HashSet();
		hashSet.add(m1);
		hashSet.add(m2);
		System.out.println(hashSet.size()); // 동등비교 하려면 hashCode() 재정의 필요 -> 1개로 나온다.
	}
}
