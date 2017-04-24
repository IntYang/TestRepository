package hw0411_ch15.hashmap;

//����
import java.util.*;

public class HashMapExample2 {
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();

		map.put(new Student(1, "ȫ�浿"), 95);
		map.put(new Student(1, "ȫ�浿"), 90);

		System.out.println("�� ��Ʈ�� ��: " + map.size());

		Set<Student> key = map.keySet();
		Iterator<Student> keyIterator = key.iterator();
		while (keyIterator.hasNext()) {
			Student student = keyIterator.next();
			System.out.println("ȫ�浿 ����: " + map.get(student)); // ��ü �״�� ������ �� �ȵǴ���
		}
	}
}
