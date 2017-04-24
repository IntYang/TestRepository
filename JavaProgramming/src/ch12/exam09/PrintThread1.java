package ch12.exam09;
//2017.04.07 수업 내용

//스레드 종료법1 : 플래그를 이용하는 방법
public class PrintThread1 extends Thread{
	//Field
	private boolean stop;
	//Constructor
	//Method
	
	@Override
	public void run() {
		while(!stop){ // while문을 빠져나오게 하는 것 -> flag
			
			System.out.println("실행 중...");
			System.out.println("실행 중...");
			
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
