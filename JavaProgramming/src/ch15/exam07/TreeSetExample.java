package ch15.exam07;
//2017.04.11 수업 내용

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		
		TreeSet<Person> set = new TreeSet<>(Collections.reverseOrder()); // 저장할 때 내림차순으로 저장
//		TreeSet<Person> set = new TreeSet<>(); 
		set.add(new Person("홍길동",45)); //  인티저 객체로 저장되고 있음
		set.add(new Person("감자바",25)); //  인티저 객체로 저장되고 있음
		set.add(new Person("박지원",31)); //  인티저 객체로 저장되고 있음
		
		
		
		for(Person p :set)
			System.out.println(p.getName() + "(" + p.getAge() + ")"); // 출력하면 오름차순으로 자동 출력
		
		/*for(int score :set.descendingSet())
			System.out.println(score); // 출력하면 내림차순으로 자동 출력
		*/
	
	}
}
