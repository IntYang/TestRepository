package hw09_ch12.exam08;

public class MovieThread extends Thread{
	@Override
	public void run() {
		while(true){
			System.out.println("�������� ����մϴ�.");
			if(this.isInterrupted())
				break;
		}
	}
}
