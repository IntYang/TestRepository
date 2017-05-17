package hw08.hw08.ch11.example03;

public class Student {
	private String studentNum;
	
	public Student(String studentNum){
		this.studentNum = studentNum;
	}
	public String getStudentNum(){
		return studentNum;
	}
	// ÀÛ¼ººÎ
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student){
			Student student = (Student) obj;
			return true;
			}
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		return Integer.parseInt(studentNum);
	}
	
}
