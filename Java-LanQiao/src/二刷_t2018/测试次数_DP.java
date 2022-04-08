package 二刷_t2018;

import java.util.Scanner;

public class 测试次数_DP {
	static int[][] dp=new int[1005][10];
	static int work(int n,int m) {
		if(dp[n][m]!=Integer.MAX_VALUE) {
			return dp[n][m];
		}
		if(n==0) {
			return dp[n][m]=0;
		}
		if(m==1) {
			return dp[n][m]=n;
		}
		for(int i=1;i<=n;i++) {
			dp[n][m]=Math.min(dp[n][m], 1+Math.max(work(i-1, m-1), work(n-i, m)));
		}
		return dp[n][m];
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		System.out.println(work(n, m));
	}
}
