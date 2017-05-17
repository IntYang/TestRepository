package ch09.exam08;
//2017. 04. 03 수업 내용
//안드로이드

public class Button { //다형성: 버튼 눌러을때 다양한 결과 나옴
	//field
	private OnClickListener onClickListener;  //interface type field
	//constructor
	
	//method
	public void setOnClickListener(OnClickListener onClickListener) { // 객체 들어와서
		this.onClickListener = onClickListener; // 외부값 받아 들어오면 위에 필드 값 넣어짐
	}
	public void touch(){ // 터차햤을 때 인터페이스 클릭
		if(onClickListener != null){
			onClickListener.onClick();
			//인터페이스 호출
		//실제 실행되는 곳은 객체다
		//우리가 onClick() 내용 작성
		//버튼은 하나지만 내용 다양하게
		}
	}

	//Nested Interface
	interface OnClickListener{ //클릭했을 때 감시하는 역할, Button과 밀접한 연관을 가진 인터페이스
		//인터페이스로 사용 가능한 객체는 setter에서 외부에서 들어옴
		void onClick(); // 버튼 클릭했을 때 클릭 알고 자동으로 실행, 실행되는 것은 객체에서.
		
		
	}
}
