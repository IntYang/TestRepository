package hw09_ch12.exam08;

public class MovieThread extends Thread{
	@Override
	public void run() {
		while(true){
			System.out.println("동영상을 재생합니다.");
			if(this.isInterrupted())
				break;
		}
	}
}
