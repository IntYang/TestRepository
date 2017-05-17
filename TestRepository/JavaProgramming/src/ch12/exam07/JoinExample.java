package ch12.exam07;
//2017.04.07 수업 시간
public class JoinExample {
	public static void main(String[] args) {
		SumThread thread =  new SumThread();
		thread.start();
		
		try{
			thread.join(); // 메인스레드가 join()요청, 일시중지  // run()메소드 종료할 때 실행대기 상태로 옴
		}catch(InterruptedException e){}
		long result = thread.getSum();
		System.out.println(result); // 메인스레드가 다 더하기도 전에 호출해서 0나옴
		
	}
}
