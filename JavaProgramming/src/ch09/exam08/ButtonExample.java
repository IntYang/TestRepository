package ch09.exam08;
//2017. 04. 03 ���� ����
public class ButtonExample {
	public static void main(String[] args) {
		Button button = new Button();
		
		button.setOnClickListener(new Button.OnClickListener(){//�������̽� ������ Ŭ������ ��Ͽ� �����ϰ� �Ű������� �����Ŵ�	
			@Override
			public void onClick() {
				System.out.println("������ �����մϴ�");
			}
		});
		
		button.touch();
		
	}
}
