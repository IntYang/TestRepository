package ch11.exam05;
//2017.04.04 ��������
public class GcExample {

	public static void main(String[] args) {
		
		for(int i=0;i<10000;i++){
		//	Member m1 = new Member(""+i); // ������ ���ڷ�
			Member m1 = new Member(String.valueOf(i)); 
			System.gc(); // �������� ���ŵ�
		}
		
		
		/*Member m1 = new Member("blue");
		m1 = null; // ������ ��ü �߻�
		
		m1 = new Member("white");
		m1 = new Member("red");
		
		System.gc(); // ������ �÷��� ���� -> Ȯ���� ����� ����.
*/	}
}
