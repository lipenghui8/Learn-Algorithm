package t2017;

import java.security.DrbgParameters.Reseed;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class mycmp implements Comparator<Integer[]>{

	@Override
	public int compare(Integer o1[], Integer o2[]) {
		// TODO Auto-generated method stub
		if(o1[0]>o2[0]) {
			return 1;
		}else if(o1[0]<o2[0]) {
			return -1;
		}else if(o1[1]>o2[1]){
			return 1;
		}else if(o1[1]<o2[1]){
			return -1;
		}else if(o1[2]>o2[2]) {
			return 1;
		}else if(o1[2]<o2[2]) {
			return -1;
		}
		return 0;
	}
	
}
public class 日期问题 {
	static int[] da= {1,3,5,7,8,10,12};
	static Integer[][] ans=new Integer[3][3];
	static int t=0;
	String[] res=new String[3];
	static boolean check(int y,int m,int d) {
		if(y>=0&&y<=59) {
			y=Integer.parseInt(String.format("20%02d", y));
		}else {
			y=Integer.parseInt(String.format("19%02d", y));
		}
		if(m<1||m>12) {
			return false;
		}
		if(d<1||d>31) {
			return false;
		}
		if(m==2) {
			if(y%4==0&&y%100!=0||y%400==0) {
				if(m>29) {
					return false;
				}
			}else {
				if(m>28) {
					return false;
				}
			}
		}
		int falg=0;
		for(int i=0;i<da.length;i++) {
			if(m==da[i]) {
				falg=1;
			}
		}
		if(falg==0&&m>30) {
			return false;
		}
		Reseed[t]=("%d-%02d-%02d",ans[0][0],ans[0][1],ans[0][2])
		ans[t][0]=y;
		ans[t][1]=m;
		ans[t][2]=d;
		t++;
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.nextLine();
		String[] s=ss.split("/");
		int a=Integer.parseInt(s[0]);
		int b=Integer.parseInt(s[1]);
		int c=Integer.parseInt(s[2]);
		//y.m.d
		check(a,b,c);
		//m.d.y
		check(c,a,b);
		//d.m.y
		check(c,b,a);
		String aString=String.format("%d-%02d-%02d",ans[0][0],ans[0][1],ans[0][2]);
		String bString=String.format("%d-%02d-%02d",ans[1][0],ans[1][1],ans[1][2]);
		String cString=String.format("%d-%02d-%02d",ans[2][0],ans[2][1],ans[2][2]);
		
		Set<String> anSet=new TreeSet<String>();
		if()
		Comparator<Integer[]> cmp=new mycmp();
		Arrays.sort(ans,cmp);
		for(int i=0;i<3;i++) {
			System.out.printf("%d-%02d-%02d",ans[i][0],ans[i][1],ans[i][2]);
			System.out.println();
		}
	}
}
