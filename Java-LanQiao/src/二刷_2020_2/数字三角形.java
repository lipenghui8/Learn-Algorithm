package 二刷_2020_2;

import java.util.Scanner;

public class 数字三角形 {
	static int[][] s=new int[105][105];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				s[i][j]=sc.nextInt();
			}
		}
		
	}
}
