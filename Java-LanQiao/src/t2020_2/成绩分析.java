package t2020_2;

import java.util.Scanner;

public class 成绩分析 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long max=Integer.MIN_VALUE,min=Integer.MAX_VALUE,sum=0;
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
		System.out.println(String.format("%.2f", sum/1.0/n));
	}
}
