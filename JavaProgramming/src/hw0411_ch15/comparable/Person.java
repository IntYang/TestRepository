package hw0411_ch15.comparable;

public class Person implements Comparable<Person> {
	public String name;
	public int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Person o) {
	/*	if(age < o.age)
			return -1;
		else if (age == o.age)
			return 0;
		
		else
			return 1;*/

//		return Integer.compare(age, o.age);
		return name.compareTo(o.name);
	
	}
}
