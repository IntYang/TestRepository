package hw06.ch09.nestedInterface;

public class ButtonExample {

	public static void main(String[] args) {
		Button btn = new Button();
		
		btn.setOnClickListener(new CallListener()); // CallListener ��ü ����
		btn.touch();
		
		btn.setOnClickListener(new MessageListener()); // MessageListener ��ü ����
		btn.touch();
	}

}
