package lanqiao_final;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class t1 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat st=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d1=st.parse("2022-01-01 06:13:22");
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(d1);
		int cnt=0;
		for(int i=1;i<=54000;i++) {
			String s=calendar.getTime().toString();
			String s1=s.substring(11,13);
			String s2=s.substring(14,16);
			String s3=s.substring(17,19);
			System.out.println(s1+" "+s2+" "+s3);
			System.out.println(s);
			if(s1.equals("14")&&s2.equals("36")&&s3.equals("20")) {
				break;
			}
			if(s2.equals(s3)) {
				cnt++;
			}
			calendar.add(Calendar.SECOND, 1);
		}
		System.out.println(cnt+"---");
	}
}
