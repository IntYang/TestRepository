package ch14.exam08;
//2017.04.11 수업 내용
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
//import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
//import java.util.function.ToLongBiFunction;

public class LambdaExpressionExample {
	
	
	private static List<Student> list  = Arrays.asList(
			new Student("홍길동", 90, 96),
			new Student("김자바", 95, 93)
		);
	
	
	public static void main(String[] args) {
		printString((s)->{return s.getName();});
		
	//	printString((s)-> {return s.getEnglishScore();});
		
		double englishAvg = avg((s)->{return s.getEnglishScore();});
		System.out.println("영어평균점수: " + englishAvg);
		
		double mathAvg = avg((s)->{return s.getMathScore();});
		System.out.println("수학평균점수: " + mathAvg);
		
	}
	
	public static void printString(Function<Student, String> function){
		for(Student student : list){
			System.out.print(function.apply(student)+ " "); // student을 String에 
		}
		System.out.println();
	}
	
	public static void printInt(ToIntFunction<Student> function){
		for(Student student : list){
			System.out.print(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}
	
	public static double avg(ToIntFunction<Student> function){
	
		// 평균 내는 것
		int sum = 0;
		for(Student student : list){
			sum += function.applyAsInt(student);
		}
		double avg = (double)sum/list.size();
		return avg;
		
		
		
		/*double englishAvg = avg(function.applyAsDouble(englishScore));
		for(Student student : list){
			System.out.println("영어 평균 점수" + function.applyAsLong(student, student));
		}
		for(Student student : list){
			System.out.println("수학 평균 점수" + function.applyAsLong(student, student));
		}
		*/
	}
	
}
