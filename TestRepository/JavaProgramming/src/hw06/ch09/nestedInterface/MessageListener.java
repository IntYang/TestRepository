package hw06.ch09.nestedInterface;

public class MessageListener implements Button.OnClickListener{ // 중첩 인터페이스의 구현내용
	@Override
	public void onClick() {
		System.out.println("메세지를 보냅니다.");
	}

}
