package ch11.exam13;

public class Member implements Comparable<Member> {
	//Field
	private String name;
	private int age;
	
	//Constructor
	public Member(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name +"(" + age + ")";
	}

	// �� �� compareTo��
	@Override
	public int compareTo(Member o) {
//		return name.toString(o.name); // String�� �����ִ� compareTo�� ���������� �迭�Ѵ�
		
		 if(name < o.name)
				return -1;
			else if(age == o.age)
				return 0;
			else
				return 1;
			
//		return Integer.compare(age, o.age);
		int sorting = name.parseInt(names);
	}
	


}
