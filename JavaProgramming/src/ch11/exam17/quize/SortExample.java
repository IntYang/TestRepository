package ch11.exam17.quize;

import java.util.Arrays;
import java.util.Collections;

public class SortExample {

	public static void main(String[] args) {
		String[] names = { "ȫ�浿", "��μ�", "�ڵ���" };
	
		System.out.println(Arrays.toString(names));
		
		//�ø��������� ����
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		
		//������������ ����
		Arrays.sort(names, Collections.reverseOrder());
		System.out.println(Arrays.toString(names));
		
		//��ü����
		
		Member[] members = {
				new Member("������", 25),
				new Member("�强��", 200),
				new Member("�������", 621)
		};
		
		
		//age�� ����
		Arrays.sort(members); 
		for(int i=0; i<members.length;i++)
			System.out.println(members[i]);
		System.out.println(Arrays.toString(members));
		Arrays.sort(members, Collections.reverseOrder());
		System.out.println(Arrays.toString(members));
		
	}

}
