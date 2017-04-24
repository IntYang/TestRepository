package ch12.exam03;
//2017.04.07 수업내용
public class WorkThread extends Thread{
	//Field
	
	//Constructor
	WorkThread(String threadName){
//		super(threadName); // 스레드 이름 생성자에서 줌. 방법 1
		setName(threadName); // 방법 2
	}
	
	//Method
	@Override
	public void run() { // setName을 run에 넣으면안됨. 
						// 스레드 실행 도중에 이름을 바꾸니까, 실행 전에 생성자에서 이름을 바꾸는 것이 바람직함
//		String threadName = Thread.currentThread().getName(); // 스레드의 이름을 얻음
		String threadName = getName(); // 스레드 내부에서 이름 받는 방법(스레드 내부만 가능함)
		for(int i=0;i<2;i++){
			System.out.println(threadName + "가 출력한 내용");
		}
	
	}
	
	
}
