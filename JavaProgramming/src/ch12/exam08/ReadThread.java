package ch12.exam08;
//2017.04.07 수업 내용
public class ReadThread extends Thread{
	//Field
	private DataBox dataBox;
	//Constructor
	public ReadThread(DataBox dataBox){ // 생성자 주입(외부에서 데이터를 집어넣어 주는 것)
		this.dataBox = dataBox;
	}
	//Method
	/*public void setDataBox(DataBox dataBox) { // Setter 주입
		this.dataBox = dataBox;
	}
	*/
	
	
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			String data = dataBox.getData();
		}
	}
}
