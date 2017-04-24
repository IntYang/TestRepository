package ch12.exam04;
//2017.04.07 수업 내용
public class Calculator {
	//Field
	private int memory;
	//Constructor
	
	//Method
	
	


	public int getMemory() {
		return memory;
	}
	
	public synchronized void setMemory(int memory) { // 이 메소드는 User1이 실행할 동안 User2가 절대 못쓴다
		this.memory = memory;
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			
		}
		System.out.println(Thread.currentThread().getName()); // 메모리에 저장되 내용 이용
	}

	
	
	
}
