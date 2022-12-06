package t202104;

import java.util.Scanner;

public class t2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),L=sc.nextInt(),r=sc.nextInt(),t=sc.nextInt();
		int[][] s=new int[1000][1000];
		int[][] a=new int[1000][1000];
		int sum=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				s[i][j]=a[i][j]+s[i-1][j]+s[i][j-1]-s[i-1][j-1];
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				int x1=Math.min(i+r, n);
				int y1=Math.min(j+r, n);
				int x2=Math.max(i-r-1, 0);
				int y2=Math.max(j-r-1, 0);
				int x3=Math.max(i-r, 1);
				int y3=Math.max(j-r, 1);
				int k=s[x1][y1]-s[x2][y1]-s[x1][y2]+s[x2][y2];
				int p=(x1-x3+1)*(y1-y3+1);
				if(k/1.0/p<=t)sum++;
			}
		}
		System.out.println(sum);
	}
}
