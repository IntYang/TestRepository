package ch14.exam06;
//2017.04.10 ���� ����
public class ConstructorReferenceExample {
	public static void main(String[] args) {
		
		/*createMember(new FunctionalInterface() { // �͸�ü
			
			@Override
			public Member createMember(String mid, String mname) {
				
				 * Member member = new Member(mid, mname);
				return member;
				
				return new Member(mid, mname);
			}
		});
	*/
//		createMember((mid, mname)->{return new Member(mid, mname);}); // ���ٽ�
//		createMember((mid, mname)->new Member(mid, mname)); // ���ٽ� ����1
		createMember(Member :: new); // ���ٽ� ���� �������� ���� ��...
									 // new�� ������ ������ '������ ����' ���� �� �� �ִ�.
		
	}
	
	public static void createMember(FunctionalInterface i){
		Member member = i.createMember("white", "ȫ�浿");
	}
}
