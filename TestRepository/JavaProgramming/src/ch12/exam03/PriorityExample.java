package ch12.exam03;
//2017.04.07 수업 내용
public class PriorityExample {
	
	public static void main(String[] args) {
		for(int i =0; i<=10 ; i++){
			Thread thread = new CalcThread("thread" + i);
			
			if(i!=10)
				thread.setPriority(Thread.MIN_PRIORITY);
			else
				thread.setPriority(Thread.MAX_PRIORITY);
			
			thread.start();
		}
		
		
	}
	
}
