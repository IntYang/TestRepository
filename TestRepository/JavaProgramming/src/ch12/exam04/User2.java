package ch12.exam04;
//2017.04.07 수업 내용
public class User2 extends Thread{
	//Field
	private Calculator calculator;
	
	//Constructor
	public User2(){
		super("User2");
	}
	
	
	//Method
	
	
	@Override
	public void run() {
		calculator.setMemory(50);
		
	
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

}
