package ch11.exam08;
//2017.04.04 ���� ����
public class StringConstructorExample  { //15��?
	public static void main(String[] args) throws Exception{
		String s1 ="abc";
		String s2 = new String("abc");
		
		char[] charArray = {'a', 'b', 'c'};
		String s3 = new String(charArray);
		byte[] byteArray = {49,50,51};
		String s4 = new String(byteArray); // ���ڿ��� ��ȯ�ϱ� ���ؼ��� ������ ��ť��Ʈ���� ã�ƺ�����
		System.out.println(s4);
		
		// �� �˾Ƶ־� ��
	/*	byte[] inputData = new byte[100];
		int readByteNo = System.in.read(inputData); // �ѹ��� �ϳ��� Ű�ڵ常 ���� �ٵ� �ٹ���Ʈ �迭�� �Ű������� ������ ���带 ȣ���ϸ� 
		String strData = new String(inputData, 0, readByteNo - 2); //����Ʈ Ű �ڵ� ���� ��Ʈ������ ��������, ���� ������
	*/
		byte[] byteArray2 = {49, 50, 51 ,52,53,54,55};
		String strData2 = new String(byteArray2, 3, 3); // ��ť��Ʈ���� ������ �����ؾ� �� , �����ڰ��� ������ ���� �޼ҵ� ã�� ��.
		System.out.println(strData2);
	}
	
	
	
}
