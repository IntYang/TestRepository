package ch12.exam09;
//2017.04.07 수업 내용
public class InterruptExample {
	public static void main(String[] args) {
		
	
		PrintThread2 thread2 = new PrintThread2();
		thread2.start();
		try{Thread.sleep(2000);} catch(Exception e){}
		thread2.interrupt();	// 일시정지가 되면 예외 발생시킴
		}
}
