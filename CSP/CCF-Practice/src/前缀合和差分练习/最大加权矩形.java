package 前缀合和差分练习;

import java.util.Scanner;

public class 最大加权矩形 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int N=125;
		int[][] a=new int[N][N];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				a[i][j]=sc.nextInt();
				a[i][j]+=a[i-1][j]+a[i][j-1]-a[i-1][j-1];
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int p=i;p<=n;p++) {
					for(int q=j;q<=n;q++) {
						int x=a[p][q]-a[i-1][q]-a[p][j-1]+a[i-1][j-1];
						max=Math.max(max, x);
					}
				}
			}
		}
		System.out.println(max);
	}
}
