package ch10.exam05;
//2017. 04. 03 수업 내용
public class BalanceInsufficientException extends Exception{ // 사용자 예외 클래스 만드는 법 2가지
	//1. 기본 생성자
	public BalanceInsufficientException(){
		super();
	}
	//2. 메시지 타입 받는 생성자
	public BalanceInsufficientException(String message){ //메시지 활용법: 실제로 은행에선 예외 번호로 관리
		super(message);
	}

}
