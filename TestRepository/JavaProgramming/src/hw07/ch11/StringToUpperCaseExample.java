package hw07.ch11;
// ����� �� �� ���ڿ��� ��ҹ��� ������� ���ϰ� ���� ��
public class StringToUpperCaseExample {
	public static void main(String[] args) {
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";
		
		System.out.println(str1.equals(str2)); // ������ ���ص� String Ŭ������ ���� ���� ��� ����
		
		String lowerStr1 = str1.toLowerCase(); //  �ҹ��ڷ� �ٲٱ�
		System.out.println("str1�� ��ȯ: "+lowerStr1);
		
		String lowerStr2 = str2.toUpperCase(); // �빮�ڷ� �ٲٱ�
		System.out.println("str2�� ��ȯ: "+lowerStr2);
		
		System.out.println(lowerStr1.equals(lowerStr2));
		
		System.out.println(str1.equalsIgnoreCase(str2)); // ��ҹ��� ������� �� �Ȱ���
	}
}
