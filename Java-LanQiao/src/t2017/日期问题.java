package t2017;

import java.util.Scanner;

public class 日期问题 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.nextLine();
		String[] s=ss.split("/");
		int a=Integer.parseInt(s[0]);
		int b=Integer.parseInt(s[1]);
		int c=Integer.parseInt(s[2]);
		//y.m.d
		int y1=0,m1=b,d1=c;
		if(a<0)
			y1=Integer.parseInt(String.format("19%02d", a));
		else {
			y1=Integer.parseInt(String.format("20%02d", a));
		}
		if() {
			
		}
		//m.d.y
		//d.m.y
	}
}
