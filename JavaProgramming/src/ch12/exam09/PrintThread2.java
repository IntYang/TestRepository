package ch12.exam09;

//2017.04.07 수업 내용
public class PrintThread2 extends Thread {
	// Field
	private boolean stop;
	// Constructor
	// Method

	@Override
	public void run() {
		try {
			while (true) { 

				System.out.println("실행 중...");
				System.out.println("실행 중...");
				// Thread.sleep(1); //일시 정지를 만들어주는 방법 1 -> catch문에서 예외처리

				
				
				/*static boolean interrupted() - 스레드 외부에서 사용
				boolean	isInterrupted() - 스레드 내부에서 사용*/
				//일시 정지를 만들어주는 방법 2
				if (isInterrupted()) { // 실행이 되었다면
					// if(Thread.interrupted()) 이것도 가능
					break; //while문 빠져나가면 밑에 자원정리, 실행종료로 감
				}
			}
		} catch (Exception e) {/* 원래 InterruptedException e
			 * { //interrupt()로 된 예외 처리 
			 * System.out.println("자원 정리");
			 * System.out.println("실행 종료"); }
			 */}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
		

	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
