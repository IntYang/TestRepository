package ch10.exam03;

//2017. 04. 03 ���� ����
public class CatchByExceptionKindExample2 {

	public static void main(String[] args) {
		
		try{
			String str = "Ab";
			System.out.println(str.length()); //��������
			
			int[] scores = {90,85};
			for(int i =0 ;i<2;i++){ // 
			 		 System.out.println(scores[i]);
	
			}
			
			String strNum = "a";
			int num = Integer.parseInt(strNum);
		
		}catch(NullPointerException | IndexOutOfBoundsException e ){ // ����ó���ڵ� ��ġ��
			System.out.println("����ó���ڵ� 1");
			
		}
			
		catch(NumberFormatException e){
			System.out.println("����ó���ڵ� 2");
		}
		
		
		
	}

}
