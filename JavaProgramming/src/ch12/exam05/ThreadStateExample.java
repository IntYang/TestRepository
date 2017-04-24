package ch12.exam05;
//2017.04.07 수업 내용
public class ThreadStateExample {
	public static void main(String[] args) {
		StatePrintThread statePrintThread = new StatePrintThread(new TargetThread()); // "타겟 스레드 상태: NEW"
		statePrintThread.start();
	}
}
