package ch12.exam05;
//2017.04.07 수업 내용
public class StatePrintThread extends Thread {	// 출력 전담 스레드, Target 스레드의 상태를 출력해줌
	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}

	public void run() {
		while(true) {
			Thread.State state = targetThread.getState(); //  targetThread의 상태를 조사 중
			System.out.println("타겟 스레드 상태: " + state);
			if(state == Thread.State.NEW) {
				targetThread.start(); // 스레드 NEW -> RUNNABLE 상태로 바뀜
			}
			if(state == Thread.State.TERMINATED) { // 스레드가 종료되면
				break; // 프린트 종료, while문 벗어남
			}
			try {
				//0.5초간 일시 정지
				Thread.sleep(10);
			} catch(Exception e) {}
		}
	}
}

