package hw0411_ch15.comparator;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorExample {
	public static void main(String[] args) {
		TreeSet<Fruit> treeSet = new TreeSet<>(new DescendingComparator());
		
		treeSet.add(new Fruit("����", 3000));
		treeSet.add(new Fruit("����", 13000));
		treeSet.add(new Fruit("����", 6000));
		
		Iterator<Fruit> iterator = treeSet.iterator();
		
		while(iterator.hasNext()){
			Fruit f = iterator.next();
			System.out.println(f.name + ":" + f.price);
		}
		
	}
}
