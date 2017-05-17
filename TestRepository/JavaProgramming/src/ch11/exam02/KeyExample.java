package ch11.exam02;
//2017.04.04 수업내용
import java.util.HashMap;

public class KeyExample {
	public static void main(String[] args) {
		HashMap hashMap = new HashMap();
		
		Key k1 = new Key(10);
		Member m1 = new Member("blue");
		hashMap.put(k1, m1); //키, 값 한 쌍 저장
		
		Key k2 = new Key(10);
		Member m2 = new Member("white");
		hashMap.put(k2, m2); //키, 값 한 쌍 저장
		
		// 여기서는 메소드 재정의 안했기 때문에 두 개 나옴
		System.out.println(hashMap.size());
		
		
		//키 번호가 같다면 같은 걸로 간주하게 수정
		
	}
}
