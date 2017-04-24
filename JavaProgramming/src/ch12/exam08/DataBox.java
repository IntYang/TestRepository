package ch12.exam08;
//2017.04.07 수업 내용
public class DataBox {
	//Field
	private String data;
	//Constructor

	
	//Method
	public synchronized String getData() {
		if(data == null){
			try{wait();}catch(InterruptedException e){}
		}
		String returnValue = data; // 담은 이유: null을 data에 넣어야 하기 때문에
		System.out.println("읽은 데이터: " + returnValue);
		data = null;
		notify(); // 상대방 깨워줘야 함
		return returnValue;
	}
	public synchronized void setData(String data) {
		if(this.data != null){ // 데이터가 이미 있는 상태면 두번 저장할 수 없으니 null
			try{wait();}catch(InterruptedException e){}
		}
		
		this.data = data;//데이터 채워넣음
		System.out.println("생성 데이터: " + this.data);
		
		
	}
	
	//getData()  setData(String data)는 다른 스레드임
}
