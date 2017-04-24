package ch12.exam01;

import java.awt.Toolkit;

//2017.04.07 수업 내용
public class BeepTask implements Runnable{
	@Override
	public void run() { // 새로운 스레드가 실행해야 할 코드 작성부분

		Toolkit toolkit = Toolkit.getDefaultToolkit(); // 스태틱 메소드
		//생성자 있는데 Toolkit() 안한 이유 -> 모든 os에서 사용가능하므로 빈 생성자임
		//스태틱 메소드 getDefaultToolkit() : os마다 다른 기능 다 셋팅해놔서 갖다 쓰기만하면 됨
		for(int i =0 ; i<5 ;i++){
			toolkit.beep(); // 워낙 빨리 실행되기 때문에 5개 냈지만 사람한텐 하나로 들림..
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				
			}
		}
	}
}
