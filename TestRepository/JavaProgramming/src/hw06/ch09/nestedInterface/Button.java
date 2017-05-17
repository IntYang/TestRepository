package hw06.ch09.nestedInterface;

public class Button {
	OnClickListener listener; // �������̽� Ÿ�� �ʵ�
	
	void setOnClickListener(OnClickListener listener){ // setter�� �Ű����� ������ ����
		this.listener = listener;
	}
	
	void touch(){
		listener.onClick(); // ���� ��ü�� OnClick ȣ��
	}
	
	interface OnClickListener{ // ��ø�������̽�
		void onClick(); // �޼ҵ� ����
	}
}
