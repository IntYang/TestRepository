package ch14.exam06;
//2017.04.10 수업 내용
public class ConstructorReferenceExample {
	public static void main(String[] args) {
		
		/*createMember(new FunctionalInterface() { // 익명객체
			
			@Override
			public Member createMember(String mid, String mname) {
				
				 * Member member = new Member(mid, mname);
				return member;
				
				return new Member(mid, mname);
			}
		});
	*/
//		createMember((mid, mname)->{return new Member(mid, mname);}); // 람다식
//		createMember((mid, mname)->new Member(mid, mname)); // 람다식 생략1
		createMember(Member :: new); // 람다식 생략 최종으로 줄인 것...
									 // new가 나오기 때문에 '생성자 참조' 임을 알 수 있다.
		
	}
	
	public static void createMember(FunctionalInterface i){
		Member member = i.createMember("white", "홍길동");
	}
}
