package hw09_ch12.exam02;

public class MusicRunnable extends Thread{

		@Override
		public void run() {
			for(int i =0;i<3;i++){
				System.out.println("������ ����մϴ�.");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){}
			}
		}
}