package ch10.exam05;
//2017. 04. 03 수업 내용
public class AccountExample {
	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("잔고: " + account.getBalance());
		account.deposit(100000);
		System.out.println("잔고: " + account.getBalance());
		try{
			account.withdraw(110000);
		}catch(BalanceInsufficientException e){
			// 예외처리코드
			System.out.println(e.getMessage());
		}
		System.out.println("잔고: " + account.getBalance());
	}
}
