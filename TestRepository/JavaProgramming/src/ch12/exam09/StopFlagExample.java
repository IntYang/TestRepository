package ch12.exam09;
//2017.04.07 수업 내용

//스레드 종료법1 : 플래그를 이용하는 방법
public class StopFlagExample {
	public static void main(String[] args) {
		
		//how1
		PrintThread1 thread = new PrintThread1();
		thread.start();
		
		try{Thread.sleep(2000);} catch(Exception e){}
		
		thread.setStop(true); //멈추고 싶을 때 flag에 false 줘서 while문 빠져나가도록
		
		
		
	}
}
