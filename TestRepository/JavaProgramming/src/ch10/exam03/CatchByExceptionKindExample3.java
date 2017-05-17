package ch10.exam03;

//2017. 04. 03 수업 내용
public class CatchByExceptionKindExample3 {

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
		
		}catch(NumberFormatException e){ // Exception 작은 범위 먼저 catch문 써줘야지 실행됨 
			System.out.println("예외처리코드 1");
			
		}
		catch(Exception e){ // Exception e = new XXXException(); -> Exception들 자동타입변환 
			System.out.println("예외처리코드 2");
			
		}
					
		
		
	}

}
