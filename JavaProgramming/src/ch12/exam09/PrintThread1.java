package ch12.exam09;
//2017.04.07 ���� ����

//������ �����1 : �÷��׸� �̿��ϴ� ���
public class PrintThread1 extends Thread{
	//Field
	private boolean stop;
	//Constructor
	//Method
	
	@Override
	public void run() {
		while(!stop){ // while���� ���������� �ϴ� �� -> flag
			
			System.out.println("���� ��...");
			System.out.println("���� ��...");
			
		}
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
