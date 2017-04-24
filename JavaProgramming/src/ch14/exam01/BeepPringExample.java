package ch14.exam01;

//2017.04.10 ���� ����
import java.awt.Toolkit;

public class BeepPringExample { // �����ϸ� �Ҹ����� �ڵ�
	public static void main(String[] args) { // ���� ������
		// �Ҹ��� ���� �ڵ�
		// �ѹ��� ���� �۾��̶�� ���� �۾���ü Ŭ���� ������������, �͸�ü�� �ٷ� ������ ��
		Thread thread = new Thread(()-> {
			
				Toolkit toolkit = Toolkit.getDefaultToolkit(); // ����ƽ �޼ҵ�
				// ������ �ִµ� Toolkit() ���� ���� -> ��� os���� ��밡���ϹǷ� �� ��������
				// ����ƽ �޼ҵ� getDefaultToolkit() : os���� �ٸ� ��� �� �����س��� ���� ���⸸�ϸ� ��
				for (int i = 0; i < 5; i++) {
					toolkit.beep(); // ���� ���� ����Ǳ� ������ 5�� ������ ������� �ϳ��� �鸲..
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {

					}
				}
			
		});
		thread.start();
		// ����Ʈ�� �ϴ� �ڵ�
		for (int i = 0; i < 5; i++) {
			System.out.println("��");

			try {
				Thread.sleep(500); // sleep������ �Ҹ� �� �� ������ �� �ڵ���µ�
			} catch (InterruptedException e) {

			}

		}
	}
}
