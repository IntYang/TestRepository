package ch10.exam05;
//2017. 04. 03 수업 내용
public class Account {
	private long balance; //잔액
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money){
		balance += money;
	}
	public void withdraw(int money) throws BalanceInsufficientException{ // 사용자 정의 예외(자바에서 제공x)
		if(money>balance){ 
			//예외발생코드
			//throw new BalanceInsufficientException(); // 예외를 발생시킨다
			throw new BalanceInsufficientException("잔고 부족"); // 구체적 메시지를 준다
		}
			balance -= money;
	}
	
}
