package ch12.exam02;

import java.awt.Toolkit;

//2017.04.07 수업 내용

public class BeepPringExample { // 실행하면 소리나는 코드
	public static void main(String[] args) { // 메인 스레드
		
		/*// 소리를 내는 코드
		BeepThread beepThread = new BeepThread();
		beepThread.start();*/
	
		// exam01, exam02 차이점
		// exam01 : 스레드 직접 만듦 , Runnable을 익명 객체로 만듦
		// exam02 : 스레드 상속해서 씀, 스레드의 자식 객체를 만든 것. 
		
		
		// 익명 객체로 만드는 법
		Thread thread = new Thread(){ // 스레드 생성
			@Override
			public void run() { // 새로운 스레드가 실행해야 할 코드 작성부분
								// run() 메소드가 끝나면 스레드 "종료(Terminated)" 상태

				Toolkit toolkit = Toolkit.getDefaultToolkit(); // 스태틱 메소드
				//생성자 있는데 Toolkit() 안한 이유 -> 모든 os에서 사용가능하므로 빈 생성자임
				//스태틱 메소드 getDefaultToolkit() : os마다 다른 기능 다 셋팅해놔서 갖다 쓰기만하면 됨
				for(int i =0 ; i<5 ;i++){
					toolkit.beep(); // 워낙 빨리 실행되기 때문에 5개 냈지만 사람한텐 하나로 들림..
					System.out.println(Thread.currentThread().getName()); // Thread-0 : 작업 번호
					try{
						Thread.sleep(500); // sleep 코드로 스레드 0.5초동안 일시 중지
					}catch(InterruptedException e){
						
					}
				}
			}
		};
			System.out.println(Thread.currentThread().getName()); // start 전이라 main 나옴
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
