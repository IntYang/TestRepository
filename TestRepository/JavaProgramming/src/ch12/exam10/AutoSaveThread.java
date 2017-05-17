package ch12.exam10;

//2017.04.07 수업 내용
public class AutoSaveThread extends Thread {

	public void save() {
		System.out.println("작업 내용을 저장함");
	}

	@Override
	public void run() {
		
		while (true) {
			try {
				
					Thread.sleep(1000); // 1초마다 저장하게 끔
					//save();
			} catch (InterruptedException e) {
				break;
			}
		save();
	}

}
}