package ch10.exam04;
//2017. 04. 03 ���� ����

//try-catch ��� ��ſ� throws Ű����� ���� ���ѱ��


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
			System.out.println("�ٽ� �Է�");
		}
		}
	static void divide(int x, int y) throws ArithmeticException{
		int result = x / y;
	}
}
