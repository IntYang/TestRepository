package ch12.exam03;
//2017.04.07 수업 내용
public class CalcThread extends Thread {
	public CalcThread(String name){
		setName(name);
	}
	
	public void run(){
		for(int i=0; i<2000000000;i++)
			System.out.println(getName());
	}
	
}
