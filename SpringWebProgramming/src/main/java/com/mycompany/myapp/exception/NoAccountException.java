package com.mycompany.myapp.exception;

// 스프링에서 트랜잭션을 처리하려면 발생되는 예외가 
// 반드시 RuntimeException 이어야한다
// 이 클래스는 거의 기계적인 코드
public class NoAccountException extends RuntimeException{
	public NoAccountException(){
		// 메시지 필요없는 예외 경우
	}
	
	public NoAccountException(String message){
		super(message);
	}
}
