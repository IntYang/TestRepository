package ch10.exam05;
//2017. 04. 03 ���� ����
public class AccountExample {
	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("�ܰ�: " + account.getBalance());
		account.deposit(100000);
		System.out.println("�ܰ�: " + account.getBalance());
		try{
			account.withdraw(110000);
		}catch(BalanceInsufficientException e){
			// ����ó���ڵ�
			System.out.println(e.getMessage());
		}
		System.out.println("�ܰ�: " + account.getBalance());
	}
}
