package ch10.exam05;
//2017. 04. 03 ���� ����
public class BalanceInsufficientException extends Exception{ // ����� ���� Ŭ���� ����� �� 2����
	//1. �⺻ ������
	public BalanceInsufficientException(){
		super();
	}
	//2. �޽��� Ÿ�� �޴� ������
	public BalanceInsufficientException(String message){ //�޽��� Ȱ���: ������ ���࿡�� ���� ��ȣ�� ����
		super(message);
	}

}
