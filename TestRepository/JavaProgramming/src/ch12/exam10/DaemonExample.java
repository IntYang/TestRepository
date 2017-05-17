package ch12.exam10;
//2017.04.07 수업 내용
/*
 * 워드 프로그램 만든다고 가정 : 깜빡 잊고 저장 안하고 종료를 눌러버림 -> 워드 프로그램 모든 프로세스 종료됨
 * 메인 스레드 종료될 때, 모든 스레드를 종료시키는 방법?
 * 주 스레드 / 보조 스레드
 * 주 스레드 죽으면 보조(데몬) 스레드 죽게 만드는 방법
 * 주 스레드가 꼭 메인 스레드인 것은 아님
 * 
*/
public class DaemonExample {
	public static void main(String[] args) {
		System.out.println("워드 프로세스를 시작함");
		
		AutoSaveThread thread = new AutoSaveThread();
		 thread.setDaemon(true); // 데몬 스레드를 만들어줌, 주 스레드 죽으면 데몬 스레드도 죽게
		thread.start(); 
		
		
		try{
			Thread.sleep(3000);
		}catch(Exception e){}
		System.out.println("워드 프로세스를 종료함");
		
		
		
		
		
		
		
	}
}
