package ch15.exam06;
//2017.04.11 수업 내용

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>(); // 검색 관련 메소드 쓰려고
		set.add(87); //  인티저 객체로 저장되고 있음
		set.add(98); //  인티저 객체로 저장되고 있음
		set.add(75); //  인티저 객체로 저장되고 있음
		set.add(95); //  인티저 객체로 저장되고 있음
		set.add(80); //  인티저 객체로 저장되고 있음
		
		Set<Integer>set2 = set.subSet(80, true , 90, false); // 범위 검색
		for(int score :set2)
			System.out.println(score);
		System.out.println("--------------------------------------");
		
		int min = set.first(); // 가장 낮은 점수 얻기
		System.out.println(min);
		
		int max = set.last(); // 가장 높은 점수 얻기
		System.out.println(max);
		
		System.out.println("--------------------------------------");
		
		
		
		Set<Integer> set3 = set.descendingSet(); // 내림 차순으로 정렬
		for(int score : set3)
			System.out.println(score);
		
		System.out.println("--------------------------------------");
		
		Set<Integer> set4 = set.descendingSet().descendingSet(); // 올림 차순으로 정렬
		for(int score : set4)
			System.out.println(score);
		
	
	}
}
