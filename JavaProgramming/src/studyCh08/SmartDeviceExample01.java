package studyCh08;

public class SmartDeviceExample01 {

	public static void main(String[] args) {
	/* class TwoGPhone extends SmartDevice.Phone{ // ���
		@Override
		void text() { // �޼ҵ� ������
			System.out.println("���ں�����.");
		}

	}
	
		TwoGPhone tg = new TwoGPhone(); // ��ü ����
		SmartDevice.Phone tg = new TwoGPhone(); // ��ü ����
		tg.text(); // �����ǵ� ��ü �޼ҵ� ����
	 */	
		
	// �͸� ��ü�� ���� ���� �����ϱ�.
		SmartDevice.Phone tg = new SmartDevice.Phone(){
			@Override
			void text(){
				System.out.println("���ں�����.");		
			}
		};
	}

}
