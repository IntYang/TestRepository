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
		
		String name = null; // 최고 점수 받은 아이디 저장
		int maxScore = 0;
		int totalScore = 0;
		
		
		// keySet 만든 방법으로 작성해 보기
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			Integer value = map.get(key);
			//int value1 = (Integer)request.getAttrivite(value).intValue(); // 인티저 객체를 int로 저장하는 방법???
	
			
			totalScore += value;
			
			if(maxScore < value)
				maxScore = value;
			name =  // name에 maxScore을 가진 key 객체를 저장한다.
			
		}

		System.out.println("평균점수: " + totalScore/map.size());
		System.out.println("최고 점수: " + maxScore);
		
		
		
		//TreeSet<String> maxSet = map.keySet();
		
		
		//System.out.println("최고점수: " + maxScore);
		
		
/////
		/*Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			if(entry.getValue() > maxScore){
				name = entry.getKey();
				maxScore = entry.getValue();
			}
			
			totalScore += entry.getValue();
		}
		
		System.out.println("평균 점수: " + totalScore / map.size());
		System.out.println("최고 점수: " + maxScore);
		System.out.println("최고 점수 받은 아이디: " + name);
		*/
		
	}
}
