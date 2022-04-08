package 二刷_2021_1;

import java.util.Scanner;

public class 杨辉三角形_暴力法 {
	static long[][] a=new long[1000][1000];
	public static void main(String[] args) {
		a[1][1]=1L;
		for(int i=2;i<1000;i++) {
			for(int j=1;j<=i;j++) {
				a[i][j]=a[i-1][j-1]+a[i-1][j];
			}
		}
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<1000;i++) {
			for(int j=1;j<=i;j++) {
				if(a[i][j]==n) {
					System.out.println((i-1)*i/2+j);
					return;
				}
			}
		}
	}
}
