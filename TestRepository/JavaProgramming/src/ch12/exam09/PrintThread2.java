package ch12.exam09;

//2017.04.07 ���� ����
public class PrintThread2 extends Thread {
	// Field
	private boolean stop;
	// Constructor
	// Method

	@Override
	public void run() {
		try {
			while (true) { 

				System.out.println("���� ��...");
				System.out.println("���� ��...");
				// Thread.sleep(1); //�Ͻ� ������ ������ִ� ��� 1 -> catch������ ����ó��

				
				
				/*static boolean interrupted() - ������ �ܺο��� ���
				boolean	isInterrupted() - ������ ���ο��� ���*/
				//�Ͻ� ������ ������ִ� ��� 2
				if (isInterrupted()) { // ������ �Ǿ��ٸ�
					// if(Thread.interrupted()) �̰͵� ����
					break; //while�� ���������� �ؿ� �ڿ�����, ��������� ��
				}
			}
		} catch (Exception e) {/* ���� InterruptedException e
			 * { //interrupt()�� �� ���� ó�� 
			 * System.out.println("�ڿ� ����");
			 * System.out.println("���� ����"); }
			 */}
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
		

	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
