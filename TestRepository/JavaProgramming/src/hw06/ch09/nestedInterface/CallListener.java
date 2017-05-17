package hw06.ch09.nestedInterface;

public class CallListener implements Button.OnClickListener { // 중첩 인터페이스를 구현한 클래스
	@Override
	public void onClick() {
		System.out.println("전화를 겁니다.");
	}
}
