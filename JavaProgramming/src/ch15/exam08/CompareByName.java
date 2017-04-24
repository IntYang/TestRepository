package ch15.exam08;

import java.util.Comparator;

//2017.04.11 수업 내용
public class CompareByName implements Comparator<Person> {
		
	@Override
		public int compare(Person o1, Person o2) {
			/*if(Integer.parseInt(o1.getName()) < Integer.parseInt(o2.getName()) )
				return -1;
			else if(Integer.parseInt(o1.getName()) == Integer.parseInt(o2.getName()))
				return 0;
			else
				return 1;
				}*/
		
		if(o1.getName().compareToIgnoreCase(o2.getName()) < 0)
			return -1;
		else if((o1.getName().compareToIgnoreCase(o2.getName()) == 0))
			return 0;
		else
			return 1;
			}
	
		
//			return o1.getName().compareTo(o2.getName());
		
	
}
