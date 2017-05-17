package ch09.exam08;
//2017. 04. 03 ���� ����
//�ȵ���̵�

public class Button { //������: ��ư �������� �پ��� ��� ����
	//field
	private OnClickListener onClickListener;  //interface type field
	//constructor
	
	//method
	public void setOnClickListener(OnClickListener onClickListener) { // ��ü ���ͼ�
		this.onClickListener = onClickListener; // �ܺΰ� �޾� ������ ���� �ʵ� �� �־���
	}
	public void touch(){ // �����x�� �� �������̽� Ŭ��
		if(onClickListener != null){
			onClickListener.onClick();
			//�������̽� ȣ��
		//���� ����Ǵ� ���� ��ü��
		//�츮�� onClick() ���� �ۼ�
		//��ư�� �ϳ����� ���� �پ��ϰ�
		}
	}

	//Nested Interface
	interface OnClickListener{ //Ŭ������ �� �����ϴ� ����, Button�� ������ ������ ���� �������̽�
		//�������̽��� ��� ������ ��ü�� setter���� �ܺο��� ����
		void onClick(); // ��ư Ŭ������ �� Ŭ�� �˰� �ڵ����� ����, ����Ǵ� ���� ��ü����.
		
		
	}
}
