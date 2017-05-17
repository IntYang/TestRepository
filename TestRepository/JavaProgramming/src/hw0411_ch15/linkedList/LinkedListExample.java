package hw0411_ch15.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i=0;i<10000;i++) // 10000 °³ °´Ã¼ »ðÀÔ
			list1.add(0, String.valueOf(i));
		
		endTime = System.nanoTime();
		System.out.println("ArrayList °É¸° ½Ã°£: " +  (endTime - startTime) + "ns");
		
		startTime = System.nanoTime(); // 10000°³ °´Ã¼ »ðÀÔ
		for(int i=0;i<10000;i++)
			list2.add(0, String.valueOf(i));
		
		endTime = System.nanoTime();
		System.out.println("LinkedList °É¸° ½Ã°£: " +  (endTime - startTime) + "ns");
 	}
}
