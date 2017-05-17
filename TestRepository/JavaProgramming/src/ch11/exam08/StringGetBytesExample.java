package ch11.exam08;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {
	public static void main(String[] args) {
		String str = "�ȳ��ϼ���";
//		String str = "abc";
		
		byte[] bytes1 = str.getBytes(); // ���ڿ��� ����Ʈ �迭�� ��ȯ
		System.out.println("bytes1.length: " + bytes1.length); // ����Ʈ�� ��ȯ�� ���� ���
		String str1 = new String(bytes1);
		System.out.println("bytes1 -> String: " + str1);
		
		try{ // String str = new String(byte[] bytes, String charsetName);
			//EUC-KR�� �̿��ؼ� ���ڵ� �� ���ڵ�
			byte[] bytes2 = str.getBytes("EUC-KR"); //���ڵ�
			System.out.println("bytes2.length: " + bytes2.length);
			String str2 = new String(bytes2, "EUC-KR"); // ���ڵ�
			System.out.println("bytes2 -> String: " + str2);
			
			//UTF-8�� �̿��ؼ� ���ڵ� �� ���ڵ�
			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length: " + bytes3.length);
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("bytes3 -> String: " + str3);
			
			
		}catch(UnsupportedEncodingException e){ // �߸��� ���ڼ��� �Ű������� �� ���
			e.printStackTrace();
		}
		
	}
}
