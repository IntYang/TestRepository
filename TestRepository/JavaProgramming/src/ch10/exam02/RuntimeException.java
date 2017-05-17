package ch10.exam02;
//2017. 04. 03 ���� ����
import java.util.Scanner;

public class RuntimeException {
	public static void main(String[] args) {

		try { // ���� �߻� ���� �ڵ�
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) { // NullPointerException ��ü ����
			System.out.println(e.getMessage()); // ��ü������ �ִ� getMessage()�� ������
												// ������ ���ڿ��� ����
		} finally { // �׻� ����
			System.out.println("���������� ����ǵ��� ��");
		}

		Scanner scanner = new Scanner(System.in); // Ű����� ���� ���ڿ� �о�ڴ�
		while (true) { // ���� ����
			System.out.print("�Է�: ");
			String strNum = scanner.nextLine();
			try {
				int num = Integer.parseInt(strNum);
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է�");
			}

		}

	}
}
