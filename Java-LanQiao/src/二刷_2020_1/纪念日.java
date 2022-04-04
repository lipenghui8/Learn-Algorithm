package 二刷_2020_1;

import java.util.Date;

public class 纪念日 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date d1=new Date(21,7,23,12,0,0);
		Date d2=new Date(120,7,1,12,0,0);
		long time=d2.getTime()-d1.getTime();
		System.out.println(time/60000);
	}
}

