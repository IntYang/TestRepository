package ch15.exam08;
//2017.04.11 ���� ����

//import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		
		TreeSet<Person> set = new TreeSet<>(new CompareByName()); 
		set.add(new Person("ȫ�浿",45)); //  ��Ƽ�� ��ü�� ����ǰ� ����
		set.add(new Person("���ڹ�",55)); //  ��Ƽ�� ��ü�� ����ǰ� ����
		set.add(new Person("������",31)); //  ��Ƽ�� ��ü�� ����ǰ� ����
		
		
		
		for(Person p :set) {
			 System.out.println(p.getName() + "(" + p.getAge() + ")"); // ����ϸ� ������������ �ڵ� ���
//			System.out.println(Integer.parseInt(p.getName()));
		}
		
	}
}
