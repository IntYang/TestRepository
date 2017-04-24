package ch11.exam13;
//2017.04.05 ���� ����
// �������� ����
// �������� ����

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class SortExample {
	public static void main(String[] args) {
		String[] names = { "ȫ�浿", "��μ�", "�ڵ���" };
		
		//System.out.println(names[1]); 
		System.out.println(Arrays.toString(names)); 
		
		//�ø��������� ����
		Arrays.sort(names);
		System.out.println(Arrays.toString(names)); 
	
		//������������ ����
		Arrays.sort(names, Collections.reverseOrder());
		System.out.println(Arrays.toString(names)); 
		
		
		Member[] members = {
				new Member("ȫ�浿", 20),
				new Member("��μ�", 15),
				new Member("�ڵ���", 25)
		};
		// Comparable Ÿ������ ��ȯ�Ͽ� ���ؾ� �ϱ� ������, Comparable �������̽��� �����ؾ� �Ѵ�.
				
		//Member ��ü�� �̸������� �����Ͻÿ�.[����]
		System.out.println("[Member]");
		System.out.println(Arrays.toString(members)); 
		// Ŭ�����̸�@�ؽ��ڵ�� �����Ƿ�, toString�� ���� �����ǰ� �ʿ��ϴ�.
		
		//�ø����� ���
		Arrays.sort(members);
		System.out.println(Arrays.toString(members)); 
		//Comparable com = new Member("ȫ�浿"); -> Ŭ������� ����ؾ� ����, �������̽���� �����ؾ� ��
		
		//�������� ����
		Arrays.sort(members, Collections.reverseOrder());
		System.out.println(Arrays.toString(members));
	}
}
