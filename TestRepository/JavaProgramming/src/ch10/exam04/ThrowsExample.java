package ch10.exam04;
//2017. 04. 03 수업 내용

//try-catch 블록 대신에 throws 키워드로 예외 떠넘기기


public class ThrowsExample {
	public static void main(String[] args) {
		 
		
		try{
		Class.forName("");
		 System.in.read();
		}catch(Exception e){
			//
		}
		
		
		try{
		divide(10,0);
		} catch(ArithmeticException e){ 
			System.out.println("다시 입력");
		}
		}
	static void divide(int x, int y) throws ArithmeticException{
		int result = x / y;
	}
}
