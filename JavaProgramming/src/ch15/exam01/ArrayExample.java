package ch15.exam01;
//2017.04.11 ���� ����
import java.util.ArrayList;
import java.util.List;

public class ArrayExample {
	public static void main(String[] args) {
		Student[] array = new Student[3];
		array[0] = new Student("s1");
		array[1] = new Student("s2");
		array[2] = new Student("s3");
		// �迭�� ����1: ���̰� ������	
		
		array[2] = null; // ��ü ���ֱ� (��������ü)
		// �迭�� ����2: �߰� �߰��� null ���� -> �� �ڸ��� �ٸ� �� ���� �� null�̳İ� �˻�
		
//		List<Student> list = new ArrayList<Student>();
		List<Student> list = new ArrayList<>(); // ���� �Ȱ�
		
		for(int i=0;i<100;i++){
			list.add(new Student("s" + i));
		}
		
		list.remove(1); // null�� ���°� �ƴ϶�, �ƿ� �����Ǽ� ���� ���� ������ ��
						// �տ��� ���� �� ä���� ����
						// ���ο� �� �ڿ� �����
						// null�ΰ� ã�� �ʿ���� �׳� ������ ��
	}
}
