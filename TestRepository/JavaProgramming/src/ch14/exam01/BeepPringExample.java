package ch14.exam01;

//2017.04.10 수업 내용
import java.awt.Toolkit;

public class BeepPringExample { // 실행하면 소리나는 코드
	public static void main(String[] args) { // 메인 스레드
		// 소리를 내는 코드
		// 한번만 쓰는 작업이라면 굳이 작업객체 클래스 생성하지말고, 익명객체로 바로 생성할 것
		Thread thread = new Thread(()-> {
			
				Toolkit toolkit = Toolkit.getDefaultToolkit(); // 스태틱 메소드
				// 생성자 있는데 Toolkit() 안한 이유 -> 모든 os에서 사용가능하므로 빈 생성자임
				// 스태틱 메소드 getDefaultToolkit() : os마다 다른 기능 다 셋팅해놔서 갖다 쓰기만하면 됨
				for (int i = 0; i < 5; i++) {
					toolkit.beep(); // 워낙 빨리 실행되기 때문에 5개 냈지만 사람한텐 하나로 들림..
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {

					}
				}
			
		});
		thread.start();
		// 프린트를 하는 코드
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");

			try {
				Thread.sleep(500); // sleep때문에 소리 다 난 다음에 띵 코드출력됨
			} catch (InterruptedException e) {

			}

		}
	}
}
