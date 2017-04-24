package ch11.exam08;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {
	public static void main(String[] args) {
		String str = "안녕하세요";
//		String str = "abc";
		
		byte[] bytes1 = str.getBytes(); // 문자열을 바이트 배열로 변환
		System.out.println("bytes1.length: " + bytes1.length); // 바이트로 변환한 길이 출력
		String str1 = new String(bytes1);
		System.out.println("bytes1 -> String: " + str1);
		
		try{ // String str = new String(byte[] bytes, String charsetName);
			//EUC-KR을 이용해서 인코딩 및 디코딩
			byte[] bytes2 = str.getBytes("EUC-KR"); //인코딩
			System.out.println("bytes2.length: " + bytes2.length);
			String str2 = new String(bytes2, "EUC-KR"); // 디코딩
			System.out.println("bytes2 -> String: " + str2);
			
			//UTF-8을 이용해서 인코딩 및 디코딩
			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length: " + bytes3.length);
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("bytes3 -> String: " + str3);
			
			
		}catch(UnsupportedEncodingException e){ // 잘못된 문자셋을 매개값으로 줄 경우
			e.printStackTrace();
		}
		
	}
}
