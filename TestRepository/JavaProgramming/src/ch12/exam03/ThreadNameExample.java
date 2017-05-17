package ch12.exam03;
//2017.04.07 수업 내용
public class ThreadNameExample {
	public static void main(String[] args) {
		
		String threadName = Thread.currentThread().getName(); // 스레드 외부라 currentThread().getName() 써야 함
		/*  위에서 코드 한 줄로 작성
		 * Thread mainThread = Thread.currentThread();
		   String threadName = mainThread.getName();
		 */
		
		
		System.out.println(threadName + "이 출력한 내용");
		
		WorkThread wt1 = new WorkThread("wt1");
		wt1.start();
		
		WorkThread wt2 = new WorkThread("wt2");
		wt2.start();
		
		// 3개의 스레드 출력
		// 스레드는 이름을 갖고 있다
		// 스레드의 이름을 알려면 Thread.currentThread().getName()
		
	}
}
