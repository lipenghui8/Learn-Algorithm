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
				int x1=i-r-1;
				if(x1<1)x1=1;
				int y1=j-r-1;
				if(y1<1)y1=1;
				
				int x2=i+r;
				int y2=j+r;
				
				if(x2>n)x2=n;
				if(y2>n)y2=n;
				int k=s[x2][y2]-s[x1][y2]-s[x2][y1]+s[x1][y1];
				if(k<=r)sum++;
			}
		}
		System.out.println(sum);
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n;j++) {
//				System.out.print(s[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
}
