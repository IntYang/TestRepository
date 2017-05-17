package ch15.exam08;
//2017.04.11 수업 내용

//import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		
		TreeSet<Person> set = new TreeSet<>(new CompareByName()); 
		set.add(new Person("홍길동",45)); //  인티저 객체로 저장되고 있음
		set.add(new Person("감자바",55)); //  인티저 객체로 저장되고 있음
		set.add(new Person("박지원",31)); //  인티저 객체로 저장되고 있음
		
		
		
		for(Person p :set) {
			 System.out.println(p.getName() + "(" + p.getAge() + ")"); // 출력하면 오름차순으로 자동 출력
//			System.out.println(Integer.parseInt(p.getName()));
		}
		
	}
}
