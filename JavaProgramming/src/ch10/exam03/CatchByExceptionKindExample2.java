package ch10.exam03;

//2017. 04. 03 수업 내용
public class CatchByExceptionKindExample2 {

	public static void main(String[] args) {
		
		try{
			String str = "Ab";
			System.out.println(str.length()); //널포인터
			
			int[] scores = {90,85};
			for(int i =0 ;i<2;i++){ // 
			 		 System.out.println(scores[i]);
	
			}
			
			String strNum = "a";
			int num = Integer.parseInt(strNum);
		
		}catch(NullPointerException | IndexOutOfBoundsException e ){ // 예외처리코드 합치기
			System.out.println("예외처리코드 1");
			
		}
			
		catch(NumberFormatException e){
			System.out.println("예외처리코드 2");
		}
		
		
		
	}

}
