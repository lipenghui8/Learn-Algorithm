package 重点二刷;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class 纪念日 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat st=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d1=st.parse("1921-07-23 12:00:00");
		Date d2=st.parse("2020-07-01 12:00:00");
		int res=(int)((d2.getTime()-d1.getTime())/(60*1000));
		System.out.println(res);
	}
}
