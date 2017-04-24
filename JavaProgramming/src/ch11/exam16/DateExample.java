package ch11.exam16;
import java.util.Calendar;
//2017.04.05 수업내용
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
//sql에 있는 것 쓰지 말것, 디비와 관련된 것
public class DateExample {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
	/*	//deprecated 메소드들
		System.out.println(now.getYear()); //117: 1900
		System.out.println(now.getMonth());
		System.out.println(now.getDate());
		System.out.println(now.getDay());
		System.out.println(now.getHours());*/
		
		//Calendar 생성자는 protected 이기 때문에 상속
	//	Calendar cal = Calendar.getInstance(Locale.CHINA); // 시간 객체
		//현재 컴퓨터의 시간을 기준으로 해서 만들어진 캘린더 객체
		//세계 시각: Locale.나라명
//		Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone(ID)); 
		//같은 시간대끼리
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int year = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DAY_OF_WEEK);
		int date = cal.get(Calendar.DAY_OF_MONTH);//0~11사이라ㅣ 1더해줘야함
		int year = cal.get(Calendar.HOUR_OF_DAY);
		int year = cal.get(Calendar.MINUTE); // 0~24시;
	}
}
