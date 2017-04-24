package ch12.exam04;
//2017.04.07 수업 내용
public class SynchronizedExample {
	
	
	public static void main(String[] args) {

		Calculator calc = new Calculator();
		
		User1 user1 = new User1(); // 스레드 생성
		
		user1.setCalculator(calc);
		user1.start();
		

		User2 user2 = new User2();
		
		user2.setCalculator(calc);
		user2.start();
	}
	
	
}
