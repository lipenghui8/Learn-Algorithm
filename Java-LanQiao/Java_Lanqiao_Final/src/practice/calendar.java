package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class calendar {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
		Date date=sdf.parse("2001/01/01");
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		ArrayList<Integer> arrayList=new ArrayList<>();
		for(int i=1;i<=10;i++) {
			arrayList.add(i*i);
		}
		int cnt=0;
		for(int i=1;i<=80;i++) {
			calendar.add(Calendar.DATE, 1);
			System.out.println(calendar.toInstant().toString());
		}
	}
}
