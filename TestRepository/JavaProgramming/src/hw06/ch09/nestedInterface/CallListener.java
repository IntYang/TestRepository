package hw06.ch09.nestedInterface;

public class CallListener implements Button.OnClickListener { // ��ø �������̽��� ������ Ŭ����
	@Override
	public void onClick() {
		System.out.println("��ȭ�� �̴ϴ�.");
	}
}
