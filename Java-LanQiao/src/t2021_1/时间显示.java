package t2021_1;

import java.util.Scanner;

public class 时间显示 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long s=Long.parseLong(sc.nextLine());
		s=s/1000%(24*60*60);
		int h=(int) (s/(60*60));
		int m=(int) (s%(60*60)/60);
		int ss=(int)(s%60);
		System.out.printf("%02d:%02d:%02d",h,m,ss);
	}
}
