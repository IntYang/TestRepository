package ch11.exam05;
//2017.04.04 수업내용
public class GcExample {

	public static void main(String[] args) {
		
		for(int i=0;i<10000;i++){
		//	Member m1 = new Member(""+i); // 정수를 문자로
			Member m1 = new Member(String.valueOf(i)); 
			System.gc(); // 무작위로 제거됨
		}
		
		
		/*Member m1 = new Member("blue");
		m1 = null; // 가비지 객체 발생
		
		m1 = new Member("white");
		m1 = new Member("red");
		
		System.gc(); // 가비지 컬렉터 제거 -> 확인할 방법은 없다.
*/	}
}
