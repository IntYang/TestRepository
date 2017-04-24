package hw0411_ch15.treeMap;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeMapExample3 {
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");

	
		System.out.println("[c~f]사이 단어 검색");
		NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", false);
		for(String word : rangeSet)
			System.out.println(word);
	}
}
