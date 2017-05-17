package ch10.exam03;

//2017. 04. 03 수업 내용
public class CatchByExceptionKindExample {

	public static void main(String[] args) {
		
		try{
			String str = null;
			System.out.println(str.length()); //널포인터
			
			int[] scores = {90,85};
			for(int i =0 ;i<3;i++){ // 
			 		 System.out.println(scores[i]);
	
			}
			
			String strNum = "a";
			int num = Integer.parseInt(strNum);
		
		}catch(NullPointerException e){ // 다중 캐치처리
			
			
		}catch(IndexOutOfBoundsException e){
			
			
		}catch(NumberFormatException e){
			
			
		}
		
		
		
	}

}
