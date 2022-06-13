package t2021;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class 完全日期 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/mm/dd");
		Date date=simpleDateFormat.parse("2001/01/01");
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(calendar.toInstant());
		
		int[] list=new int[10];
		ArrayList<Integer> arrayList=new ArrayList<>();
		
		for(int i=1;i<=10;i++) {
			arrayList.add(i*i);
		}
		for(int i=1;i<=10000;i++) {
			StringBuilder y=new StringBuilder();
			StringBuilder m=new StringBuilder();
			StringBuilder d=new StringBuilder();
			
		}
	}
}
