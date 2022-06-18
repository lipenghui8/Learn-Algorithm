package 二刷_2020_2;

import java.util.Scanner;

public class 成绩分析 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		int sum=0;
		for(int i=1;i<=n;i++) {
			int x=sc.nextInt();
			if(x>max) {
				max=x;
			}
			if(x<min) {
				min=x;
			}
			sum+=x;
		}
		System.out.println(max);
		System.out.println(min);
//		System.out.printf("%.2f",(double)Math.round(sum*1.0/n*100)/100);
		System.out.printf("%.2f",sum*1.0/n);
	}
}
