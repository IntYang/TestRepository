package ch12.exam08;
//2017.04.07 ���� ����
public class ReadThread extends Thread{
	//Field
	private DataBox dataBox;
	//Constructor
	public ReadThread(DataBox dataBox){ // ������ ����(�ܺο��� �����͸� ����־� �ִ� ��)
		this.dataBox = dataBox;
	}
	//Method
	/*public void setDataBox(DataBox dataBox) { // Setter ����
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
