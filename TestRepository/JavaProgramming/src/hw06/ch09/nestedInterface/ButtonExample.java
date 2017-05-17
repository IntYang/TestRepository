package hw06.ch09.nestedInterface;

public class ButtonExample {

	public static void main(String[] args) {
		Button btn = new Button();
		
		btn.setOnClickListener(new CallListener()); // CallListener 梓端 持失
		btn.touch();
		
		btn.setOnClickListener(new MessageListener()); // MessageListener 梓端 持失
		btn.touch();
	}

}
