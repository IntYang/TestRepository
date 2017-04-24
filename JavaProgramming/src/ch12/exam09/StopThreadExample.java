package ch12.exam09;
//2017.04.07 수업 내용
public class StopThreadExample {
	public static void main(String[] args) {
		
		//how1
		PrintThread1 thread = new PrintThread1();
		thread.start();
		
		try{Thread.sleep(2000);} catch(Exception e){}
		
		thread.setStop(true);
		
		
		/*//how2
		PrintThread2 thread2 = new PrintThread2();
		thread2.start();
		try{Thread.sleep(2000);} catch(Exception e){}
		thread2.interrupt();*/
	}
}
