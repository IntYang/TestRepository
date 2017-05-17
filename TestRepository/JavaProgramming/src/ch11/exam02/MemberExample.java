package ch11.exam02;

import java.util.HashSet;

//2017.04.04 ��������

public class MemberExample {
	public static void main(String[] args) {
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		
		//hashcode�� ���: �޸� ���� �������� ���� ���̹Ƿ�, ������ �ٸ��� �ؽ��ڵ�� �ٸ��� ���´�.
		System.out.println(m1.hashCode()); 
		System.out.println(m2.hashCode()); 
		//����񱳸� �� �� �ؽ��ڵ� �Ȱ��� ������ �� ��찡 ����.
		// HashSet, HaseMap, Hashtable ���� �÷��� ��ü�� ����� ��.
				
		HashSet hashSet = new HashSet();
		hashSet.add(m1);
		hashSet.add(m2);
		System.out.println(hashSet.size()); // ����� �Ϸ��� hashCode() ������ �ʿ� -> 1���� ���´�.
	}
}
