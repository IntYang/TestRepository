package hw0411_ch15.prac08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<Student> set = new HashSet<>();
		
		set.add(new Student(1, "ȫ�浿"));
		set.add(new Student(2, "�ſ��"));
		set.add(new Student(1, "���ο�")); // �й� ������ ���� �ȵ�

		Iterator<Student> i = set.iterator();
		
		while(i.hasNext()){
			Student student = i.next();
			System.out.println(student.studentNum + ":" + student.name);
		}
	
	}
}
