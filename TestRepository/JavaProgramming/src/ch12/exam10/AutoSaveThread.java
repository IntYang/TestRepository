package ch12.exam10;

//2017.04.07 ���� ����
public class AutoSaveThread extends Thread {

	public void save() {
		System.out.println("�۾� ������ ������");
	}

	@Override
	public void run() {
		
		while (true) {
			try {
				
					Thread.sleep(1000); // 1�ʸ��� �����ϰ� ��
					//save();
			} catch (InterruptedException e) {
				break;
			}
		save();
	}

}
}