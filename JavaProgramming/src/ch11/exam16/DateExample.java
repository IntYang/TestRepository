package ch11.exam16;
import java.util.Calendar;
//2017.04.05 ��������
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
//sql�� �ִ� �� ���� ����, ���� ���õ� ��
public class DateExample {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
	/*	//deprecated �޼ҵ��
		System.out.println(now.getYear()); //117: 1900
		System.out.println(now.getMonth());
		System.out.println(now.getDate());
		System.out.println(now.getDay());
		System.out.println(now.getHours());*/
		
		//Calendar �����ڴ� protected �̱� ������ ���
	//	Calendar cal = Calendar.getInstance(Locale.CHINA); // �ð� ��ü
		//���� ��ǻ���� �ð��� �������� �ؼ� ������� Ķ���� ��ü
		//���� �ð�: Locale.�����
//		Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone(ID)); 
		//���� �ð��볢��
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int year = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DAY_OF_WEEK);
		int date = cal.get(Calendar.DAY_OF_MONTH);//0~11���̶�� 1���������
		int year = cal.get(Calendar.HOUR_OF_DAY);
		int year = cal.get(Calendar.MINUTE); // 0~24��;
	}
}
