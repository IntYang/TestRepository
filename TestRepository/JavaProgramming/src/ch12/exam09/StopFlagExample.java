package ch12.exam09;
//2017.04.07 ���� ����

//������ �����1 : �÷��׸� �̿��ϴ� ���
public class StopFlagExample {
	public static void main(String[] args) {
		
		//how1
		PrintThread1 thread = new PrintThread1();
		thread.start();
		
		try{Thread.sleep(2000);} catch(Exception e){}
		
		thread.setStop(true); //���߰� ���� �� flag�� false �༭ while�� ������������
		
		
		
	}
}
