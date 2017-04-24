package ch12.exam08;
//2017.04.07 수업 내용
public class WaitNotifyExample {
	public static void main(String[] args) {
		//공유객체 생성 
		DataBox dataBox = new DataBox();
		
		//스레드 객체 생성
		ReadThread t1 = new ReadThread(dataBox); // dataBox에서 10번 읽을 것
		WriteThread t2 = new WriteThread(dataBox); // dataBox에서 10번 쓸 것
		
		//스레드 실행
		t1.start();
		t2.start();
		// Consumer, Producer 번갈아 가면서 1번씩 실행
	
	}
}
