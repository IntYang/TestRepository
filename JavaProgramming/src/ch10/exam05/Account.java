package ch10.exam05;
//2017. 04. 03 ���� ����
public class Account {
	private long balance; //�ܾ�
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money){
		balance += money;
	}
	public void withdraw(int money) throws BalanceInsufficientException{ // ����� ���� ����(�ڹٿ��� ����x)
		if(money>balance){ 
			//���ܹ߻��ڵ�
			//throw new BalanceInsufficientException(); // ���ܸ� �߻���Ų��
			throw new BalanceInsufficientException("�ܰ� ����"); // ��ü�� �޽����� �ش�
		}
			balance -= money;
	}
	
}
