package ch10.exam03;

//2017. 04. 03 ���� ����
public class CatchByExceptionKindExample3 {

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
		
		}catch(NumberFormatException e){ // Exception ���� ���� ���� catch�� ������� ����� 
			System.out.println("����ó���ڵ� 1");
			
		}
		catch(Exception e){ // Exception e = new XXXException(); -> Exception�� �ڵ�Ÿ�Ժ�ȯ 
			System.out.println("����ó���ڵ� 2");
			
		}
					
		
		
	}

}
