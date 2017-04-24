package studyCh08;

public class SmartDeviceExample01 {

	public static void main(String[] args) {
	/* class TwoGPhone extends SmartDevice.Phone{ // 상속
		@Override
		void text() { // 메소드 재정의
			System.out.println("문자보내다.");
		}

	}
	
		TwoGPhone tg = new TwoGPhone(); // 객체 생성
		SmartDevice.Phone tg = new TwoGPhone(); // 객체 생성
		tg.text(); // 재정의된 객체 메소드 실행
	 */	
		
	// 익명 객체로 위의 내용 생성하기.
		SmartDevice.Phone tg = new SmartDevice.Phone(){
			@Override
			void text(){
				System.out.println("문자보내다.");		
			}
		};
	}

}
