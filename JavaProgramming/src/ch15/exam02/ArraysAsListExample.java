package ch15.exam02;
//2017.04.11 수업 내용
import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("홍길동", "신용권", "감자바"); // 잠깐 만들어서 테스트할 때 쓰는 용도, 배열하고 똑같음
		for(String name : list1){
			System.out.println(name);
		}
		
//		list1.add("ddd"); // 불가능. 고정된 크기이므로 추가 불가
		
		List<Integer> list2 = Arrays.asList(1,2,3);
		for(int value : list2){
			System.out.println(value);
		}
	}
}
