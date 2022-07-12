package t2021;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class 完全日期 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		Date date=sdf.parse("2001/01/01");
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		ArrayList<Integer> arrayList=new ArrayList<>();
		for(int i=1;i<=10;i++) {
			arrayList.add(i*i);
		}
		int cnt=0;
		for(int i=1;i<=8000;i++) {
			String d=calendar.toInstant().toString();
			if(d.substring(0,10).equals("2022-01-01")) {
				break;
			}
			int sum=0;
			for(int j=0;j<10;j++) {
				if(j==4||j==7) {
					continue;
				}
				sum+=d.charAt(j)-'0';
			}
			System.out.println(sum+"----"+d);
			if(arrayList.contains(sum)) {
				cnt++;
			}
			calendar.add(Calendar.DATE, 1);
		}
		System.out.println(cnt);
	}
}
