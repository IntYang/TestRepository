package hw06.ch10.example07;

public class WrongPasswordException extends Exception {
	public WrongPasswordException(){
		
	}
	
	public WrongPasswordException(String message){
		super(message);
	}
}
