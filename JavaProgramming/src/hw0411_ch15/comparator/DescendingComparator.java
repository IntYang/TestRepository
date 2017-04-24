package hw0411_ch15.comparator;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Fruit>{
	@Override
	public int compare(Fruit o1, Fruit o2) {
		/*if(o1.price < o2.price )
			return -1;
		else if(o1.price == o2.price)
			return 0;
		else
			return 1;*/
//			return Integer.compare(o1.price, o2.price);
//		return o1.name.compareTo(o2.name);
		
		if((o1.name.compareToIgnoreCase(o2.name) < 0))
				return -1;
		else if((o1.name.compareToIgnoreCase(o2.name)) == 0)
			return 0;
		else
			return 1;
	
	}
}
