package ch11.exam08;
//2017.04.04 ���� ����

// �� ���� ����ó: �־��� �����ڿ����� � �ܾ � ������ �˻��� ��
public class StringIndexOfExample {
	public static void main(String[] args) {
		String subject = "�ں� ���α׷���";
		
		int location = subject.indexOf("���α׶��"); //contains() ��ü���� ��� ����
		System.out.println(location); //�ε����� ���� ��ġ ���
		
		if(subject.indexOf("�ڹ�") != -1) // �־��� ���ڿ��� ���ԵǾ� ������
			System.out.println("�ڹٿ� ���õ� å�̴�");
		else
			System.out.println("�ڹٿ� ���þ��� å�̴�");
	
	}
}
