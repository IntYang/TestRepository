package hw06.ch09.nestedInterface;

public class Button {
	OnClickListener listener; // 인터페이스 타입 필드
	
	void setOnClickListener(OnClickListener listener){ // setter로 매개변수 다형성 구현
		this.listener = listener;
	}
	
	void touch(){
		listener.onClick(); // 구현 객체의 OnClick 호출
	}
	
	interface OnClickListener{ // 중첩인터페이스
		void onClick(); // 메소드 선언
	}
}
