package hw06.ch10.example07;

public class LoginExample {
	public static void main(String[] args) {
		try{
			login("white","12345");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			login("blue", "11111");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void login(String id, String password) throws NotExistIDException, WrongPasswordException{
		//id "blue"�ƴϸ� NotExistIDException
		if(!id.equals("blue")){
			throw new NotExistIDException("ID ����");
		}
		//password "12345" �ƴϸ� WrongPasswordException
		if(!password.equals("12345")){
			throw new WrongPasswordException("PW ����");
		}
	
	}
	
}
