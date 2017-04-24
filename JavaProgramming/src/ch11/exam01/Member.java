package ch11.exam01;
//2017.04.04 ��������
public class Member {
	//Field
	private String id;
	
	//Constructor
	public Member(String id){
		this.id = id;
	}
	
	//Method ������
	@Override
	public boolean equals(Object obj) { // �Ű������� ������ ��ü ����: �ڹ��� ��� ��ü(�ڹ��� ��� ��ü�� Object�� ��� �ޱ� ������
		if(obj instanceof Member){ //  Member ��ü�� ������
			Member target = (Member) obj; //���� Ÿ�� ��ȯ�ϴ� ����: �ڽ� ��ü �� �� �ֵ���
			if(id.equals(target.id))
				return true;
		}
		
			return false;
	
	}
	
	
	
}
