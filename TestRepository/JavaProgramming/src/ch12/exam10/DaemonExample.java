package ch12.exam10;
//2017.04.07 ���� ����
/*
 * ���� ���α׷� ����ٰ� ���� : ���� �ذ� ���� ���ϰ� ���Ḧ �������� -> ���� ���α׷� ��� ���μ��� �����
 * ���� ������ ����� ��, ��� �����带 �����Ű�� ���?
 * �� ������ / ���� ������
 * �� ������ ������ ����(����) ������ �װ� ����� ���
 * �� �����尡 �� ���� �������� ���� �ƴ�
 * 
*/
public class DaemonExample {
	public static void main(String[] args) {
		System.out.println("���� ���μ����� ������");
		
		AutoSaveThread thread = new AutoSaveThread();
		 thread.setDaemon(true); // ���� �����带 �������, �� ������ ������ ���� �����嵵 �װ�
		thread.start(); 
		
		
		try{
			Thread.sleep(3000);
		}catch(Exception e){}
		System.out.println("���� ���μ����� ������");
		
		
		
		
		
		
		
	}
}
