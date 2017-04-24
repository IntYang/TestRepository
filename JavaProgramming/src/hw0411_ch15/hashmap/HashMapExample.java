package hw0411_ch15.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) {
		//Map 컬렉션 생성
		Map<String, Integer>map = new HashMap<String, Integer>();
		
		//객체 저장
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95); // 앞의 홍길동 점수 바꿔짐
		System.out.println("총 엔트리 수: " + map.size());
		
		//객체 찾기
		System.out.println("\t홍길동:" + map.get("홍길동"));
		System.out.println();
		
		//객체 하나씩 처리
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator(); // Iterator로 처리
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			Integer value = map.get(key); // 키 값으로 값 받아옴
			System.out.println("\t" + key+ ":" + value);
		}
		
		System.out.println();
		
		//객체 삭제
		map.remove("홍길동");
		System.out.println("총 Entry수: " + map.size());

		//객체 하나씩 처리
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()){
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();  // key 직접 받아옴
			Integer value = entry.getValue(); // 값 직접 받아옴
			System.out.println("\t" + key + ":" + value);
			
		}
		
		System.out.println();
		
		// 객체 전체 삭제
		map.clear();
		System.out.println("총 Entry수: " + map.size());
		
	}
}
