package t2021_1;

import java.util.Scanner;

public class 杨辉三角形 {
	static long[][] s=new long[1001][1001];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		s[1][1]=1;
		for(int i=2;i<=1000;i++) {
			for(int j=1;j<=i;j++) {
				s[i][j]=s[i-1][j]+s[i-1][j-1];
			}
		}
		int flag=0;
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=i;j++) {
				if(s[i][j]==n) {
					System.out.print(i*(i-1)/2+j);
					return;
				}
				
			}
		}
	}
}
