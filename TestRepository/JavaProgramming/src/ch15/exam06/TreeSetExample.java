package ch15.exam06;
//2017.04.11 ���� ����

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>(); // �˻� ���� �޼ҵ� ������
		set.add(87); //  ��Ƽ�� ��ü�� ����ǰ� ����
		set.add(98); //  ��Ƽ�� ��ü�� ����ǰ� ����
		set.add(75); //  ��Ƽ�� ��ü�� ����ǰ� ����
		set.add(95); //  ��Ƽ�� ��ü�� ����ǰ� ����
		set.add(80); //  ��Ƽ�� ��ü�� ����ǰ� ����
		
		Set<Integer>set2 = set.subSet(80, true , 90, false); // ���� �˻�
		for(int score :set2)
			System.out.println(score);
		System.out.println("--------------------------------------");
		
		int min = set.first(); // ���� ���� ���� ���
		System.out.println(min);
		
		int max = set.last(); // ���� ���� ���� ���
		System.out.println(max);
		
		System.out.println("--------------------------------------");
		
		
		
		Set<Integer> set3 = set.descendingSet(); // ���� �������� ����
		for(int score : set3)
			System.out.println(score);
		
		System.out.println("--------------------------------------");
		
		Set<Integer> set4 = set.descendingSet().descendingSet(); // �ø� �������� ����
		for(int score : set4)
			System.out.println(score);
		
	
	}
}
