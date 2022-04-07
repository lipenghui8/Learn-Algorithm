package 二刷_2021_1;

import java.util.Scanner;

public class 时间显示 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long a=sc.nextLong();
		a=a%(24*60*60*1000);
		long h=a/(60*60*1000);
		long m=a/(60*1000)%60;
		long s=a/1000%60;
		System.out.println(String.format("%02d:%02d:%02d", h,m,s));
	}
}
