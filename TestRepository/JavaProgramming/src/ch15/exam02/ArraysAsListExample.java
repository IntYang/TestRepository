package ch15.exam02;
//2017.04.11 ���� ����
import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("ȫ�浿", "�ſ��", "���ڹ�"); // ��� ���� �׽�Ʈ�� �� ���� �뵵, �迭�ϰ� �Ȱ���
		for(String name : list1){
			System.out.println(name);
		}
		
//		list1.add("ddd"); // �Ұ���. ������ ũ���̹Ƿ� �߰� �Ұ�
		
		List<Integer> list2 = Arrays.asList(1,2,3);
		for(int value : list2){
			System.out.println(value);
		}
	}
}
