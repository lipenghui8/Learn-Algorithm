package 前缀合和差分练习;

import java.util.Scanner;
public class 地毯 {
	static int M=1010;
	static int a[][]=new int[M][M];
	public static void insert(int x1,int y1,int x2,int y2,int c) {
		a[x1][y1]+=c;
		a[x1][y2+1]-=c;
		a[x2+1][y1]-=c;
		a[x2+1][y2+1]+=c;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		for(int i=1;i<=m;i++) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			insert(x1,y1,x2,y2,1);
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				a[i][j]+=a[i-1][j]+a[i][j-1]-a[i-1][j-1];
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
