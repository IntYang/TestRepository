package ch12.exam06;
//2017.04.07 ���� ����
public class ThreadB extends Thread{
	//Field
	private boolean stop = false; // �����带 �����ϱ� ���� ����
	private boolean work = true; // ������ �۾��� �纸�� ����
	//Constructor
	//Method
	public void run(){
		while(!stop){
			if(work){ // ���ǹ��� �۾� ��
				System.out.println("ThreadB �۾� ��....");
			}
			else // �纸
				yield();
		}
		System.out.println("ThreadB �۾� ����");
			
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public void setWork(boolean work) {
		this.work = work;
	}
	
}
