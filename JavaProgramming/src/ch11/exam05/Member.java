package ch11.exam05;
//2017.04.04 수업내용
public class Member {
	//Field
	private String id;
	
	//Constructor
	public Member(String id){
		this.id = id;
	}
	
	//Method
	@Override
	public String toString(){
		return id;
	}
	
	@Override
	protected void finalize() throws Throwable { //가비지 컬렉터에 의해 제거될 때 딱 실행됨 "나죽네" 하고 켁
		System.out.println(id+ "가 제거됨");
	}
	
		
	//자바에서 언제 제거할 지 잘 모르기 때문에 소멸자는 잘 안씀
}
