package ch12.exam08;
//2017.04.07 ���� ����
public class DataBox {
	//Field
	private String data;
	//Constructor

	
	//Method
	public synchronized String getData() {
		if(data == null){
			try{wait();}catch(InterruptedException e){}
		}
		String returnValue = data; // ���� ����: null�� data�� �־�� �ϱ� ������
		System.out.println("���� ������: " + returnValue);
		data = null;
		notify(); // ���� ������� ��
		return returnValue;
	}
	public synchronized void setData(String data) {
		if(this.data != null){ // �����Ͱ� �̹� �ִ� ���¸� �ι� ������ �� ������ null
			try{wait();}catch(InterruptedException e){}
		}
		
		this.data = data;//������ ä������
		System.out.println("���� ������: " + this.data);
		
		
	}
	
	//getData()  setData(String data)�� �ٸ� ��������
}
