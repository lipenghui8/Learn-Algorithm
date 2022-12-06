package 前缀合和差分练习;

import java.util.Scanner;

public class 选择首都 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt(),c=sc.nextInt();
		int N=1005;
		int[][] a=new int[N][N];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				a[i][j]=sc.nextInt();
				a[i][j]+=a[i-1][j]+a[i][j-1]-a[i-1][j-1];
			}
		}
		int max=Integer.MIN_VALUE;
		int ansi=0,ansj=0;
		for(int i=c;i<=n;i++) {
			for(int j=c;j<=m;j++) {
				int q=a[i][j]-a[i-c][j]-a[i][j-c]+a[i-c][j-c];
				if(q>max) {
					max=q;
					ansi=i-c+1;
					ansj=j-c+1;
				}
			}
		}
		System.out.println(ansi+" "+ansj);
	}
}
