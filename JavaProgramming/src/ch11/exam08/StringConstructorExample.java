package ch11.exam08;
//2017.04.04 수업 내용
public class StringConstructorExample  { //15개?
	public static void main(String[] args) throws Exception{
		String s1 ="abc";
		String s2 = new String("abc");
		
		char[] charArray = {'a', 'b', 'c'};
		String s3 = new String(charArray);
		byte[] byteArray = {49,50,51};
		String s4 = new String(byteArray); // 문자열로 변환하기 위해서는 생성자 다큐먼트에서 찾아봐ㅑ야
		System.out.println(s4);
		
		// 잘 알아둬야 함
	/*	byte[] inputData = new byte[100];
		int readByteNo = System.in.read(inputData); // 한번에 하나의 키코드만 읽음 근데 바바이트 배열을 매개값으로 갖가ㅗ 리드를 호출하면 
		String strData = new String(inputData, 0, readByteNo - 2); //바이트 키 코드 값을 스트링으로 리턴해줌, 엔터 전까지
	*/
		byte[] byteArray2 = {49, 50, 51 ,52,53,54,55};
		String strData2 = new String(byteArray2, 3, 3); // 도큐먼트에서 생성자 참고해야 함 , 생성자가ㅣ 없으면 정적 메소드 찾을 것.
		System.out.println(strData2);
	}
	
	
	
}
