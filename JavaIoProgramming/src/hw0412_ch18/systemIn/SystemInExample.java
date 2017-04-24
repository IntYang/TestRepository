package hw0412_ch18.systemIn;

import java.io.IOException;
import java.io.InputStream;

public class SystemInExample {
	public static void main(String[] args) throws IOException {
		System.out.println("--Menu--");
		System.out.println("1. 예금 조회");
		System.out.println("2. 예금 출금");
		System.out.println("3. 예금 입금");
		System.out.println("4. 종료");
		System.out.print(">>선택하셈  : ");
		
		while(true){
		InputStream is = System.in; //키보드 입력 스트림으로, 선택 내용을 받는다.
		char inputChar = (char) is.read(); // 예외 처리를 해야 오류가 안난다, is에서 읽은 char수를 char형태로 변환하여 inputChar에 대입한다.
		
		switch(inputChar){ // inputChar 입력받는 경우 -> 어떤 결과 나올 것인가 case별로 
			case '1' : 
				System.out.println("예금 조회"); break;
			case '2' :
				System.out.println("예금 출금"); break;
			case '3' :
				System.out.println("예금 입금"); break;
			case '4' :
				System.out.println("종료"); break;
		}
	
		}
	
	
	
	
	}
}
