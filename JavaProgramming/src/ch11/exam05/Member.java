package ch11.exam05;
//2017.04.04 ��������
public class Member {
	//Field
	private String id;
	
	//Constructor
	public Member(String id){
		this.id = id;
	}
	
	//Method
	@Override
	public String toString(){
		return id;
	}
	
	@Override
	protected void finalize() throws Throwable { //������ �÷��Ϳ� ���� ���ŵ� �� �� ����� "���׳�" �ϰ� ��
		System.out.println(id+ "�� ���ŵ�");
	}
	
		
	//�ڹٿ��� ���� ������ �� �� �𸣱� ������ �Ҹ��ڴ� �� �Ⱦ�
}
