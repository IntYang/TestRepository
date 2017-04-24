package ch09.exam08;
//2017. 04. 03 수업 내용
public class ButtonExample {
	public static void main(String[] args) {
		Button button = new Button();
		
		button.setOnClickListener(new Button.OnClickListener(){//인터페이스 구현한 클래스를 블록에 정의하고 매개값으로 넣은거다	
			@Override
			public void onClick() {
				System.out.println("서버에 접속합니다");
			}
		});
		
		button.touch();
		
	}
}
