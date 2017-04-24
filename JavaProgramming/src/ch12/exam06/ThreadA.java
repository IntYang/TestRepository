package ch12.exam06;
//2017.04.07 수업 내용
public class ThreadA extends Thread{
	//Field
	private boolean stop = false; // 스레드를 종료하기 위한 목적
	private boolean work = true; // 스레드 작업을 양보할 목적
	//Constructor
	//Method
	public void run(){
		while(!stop){
			if(work){ // 무의미한 반복을 할 때
				System.out.println("ThreadA 작업 중....");
			}
			else // 양보
				yield();
		}
		System.out.println("ThreadA 작업 종료");
			
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public void setWork(boolean work) {
		this.work = work;
	}
	
}
