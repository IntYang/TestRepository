package ch12.exam08;
//2017.04.07 ���� ����
public class WaitNotifyExample {
	public static void main(String[] args) {
		//������ü ���� 
		DataBox dataBox = new DataBox();
		
		//������ ��ü ����
		ReadThread t1 = new ReadThread(dataBox); // dataBox���� 10�� ���� ��
		WriteThread t2 = new WriteThread(dataBox); // dataBox���� 10�� �� ��
		
		//������ ����
		t1.start();
		t2.start();
		// Consumer, Producer ������ ���鼭 1���� ����
	
	}
}
