package ch11.exam10;
//2017.04.05 ���� ����
import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		String text = "ȫ�浿/�̼�ȫ/�ڿ���";
		
		// ���1 : ��ü ��ū���� �޾ƿͼ�
		// ��Ʈ��, �����ڸ� �޾ƿ�
		StringTokenizer st = new StringTokenizer(text, "/");
		int countTokens = st.countTokens(); //������ �ʰ� �����ִ� ��ū�� ���� ����
		for(int i=0; i<countTokens;i++){ //��ū�� �� ��ŭ �ݺ���
			String token = st.nextToken(); // ���� ��ū���� �޾ƿ´�
			System.out.println(token); //�޾ƿ� ��ū ������ ����Ѵ�
		}
		
		System.out.println(); // ���� ��ĭ ���
		
		// ���2 : �����ִ� ��ū�� ���� �ִ��� �˻��� ��
		st = new StringTokenizer(text, "/"); // 
		while(st.hasMoreTokens()){// �����ִ� ��ū�� Ȯ���ϰ� while������ ����
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
