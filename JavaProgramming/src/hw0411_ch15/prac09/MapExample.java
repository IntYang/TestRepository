package hw0411_ch15.prac09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapExample {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("blue", 96);
		map.put("hone", 86);
		map.put("white", 92);
		
		String name = null; // �ְ� ���� ���� ���̵� ����
		int maxScore = 0;
		int totalScore = 0;
		
		
		// keySet ���� ������� �ۼ��� ����
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			Integer value = map.get(key);
			//int value1 = (Integer)request.getAttrivite(value).intValue(); // ��Ƽ�� ��ü�� int�� �����ϴ� ���???
	
			
			totalScore += value;
			
			if(maxScore < value)
				maxScore = value;
			name =  // name�� maxScore�� ���� key ��ü�� �����Ѵ�.
			
		}

		System.out.println("�������: " + totalScore/map.size());
		System.out.println("�ְ� ����: " + maxScore);
		
		
		
		//TreeSet<String> maxSet = map.keySet();
		
		
		//System.out.println("�ְ�����: " + maxScore);
		
		
/////
		/*Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			if(entry.getValue() > maxScore){
				name = entry.getKey();
				maxScore = entry.getValue();
			}
			
			totalScore += entry.getValue();
		}
		
		System.out.println("��� ����: " + totalScore / map.size());
		System.out.println("�ְ� ����: " + maxScore);
		System.out.println("�ְ� ���� ���� ���̵�: " + name);
		*/
		
	}
}
