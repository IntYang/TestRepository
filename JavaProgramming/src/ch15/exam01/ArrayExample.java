package ch15.exam01;
//2017.04.11 수업 내용
import java.util.ArrayList;
import java.util.List;

public class ArrayExample {
	public static void main(String[] args) {
		Student[] array = new Student[3];
		array[0] = new Student("s1");
		array[1] = new Student("s2");
		array[2] = new Student("s3");
		// 배열의 단점1: 길이가 고정적	
		
		array[2] = null; // 객체 없애기 (가비지객체)
		// 배열의 단점2: 중간 중간에 null 존재 -> 빈 자리에 다른 것 넣을 때 null이냐고 검사
		
//		List<Student> list = new ArrayList<Student>();
		List<Student> list = new ArrayList<>(); // 위와 똑같
		
		for(int i=0;i<100;i++){
			list.add(new Student("s" + i));
		}
		
		list.remove(1); // null로 들어가는게 아니라, 아예 삭제되서 뒤의 것이 땡겨져 옴
						// 앞에서 부터 다 채워져 있음
						// 새로운 거 뒤에 저장됨
						// null인거 찾을 필요없이 그냥 넣으면 됨
	}
}
