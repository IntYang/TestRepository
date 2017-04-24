package hw06.ch10.example07;

public class NotExistIDException extends Exception { //사용자 정의 예외클래스: Exception클래스 상속받아야함
	//생성자
	public NotExistIDException(){
		
	}
	
	
	//메시지 매개변수 생성자
	public NotExistIDException(String message){
		super(message);
	}
}
