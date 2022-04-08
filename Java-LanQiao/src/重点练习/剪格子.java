package 重点练习;

import java.util.Iterator;
import java.util.Scanner;

public class 剪格子 {
	static int[][] s=new int[15][15];
	static int[][] v=new int[15][15];
	static int m,n,sum=0,min=Integer.MAX_VALUE;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static void dfs(int x,int y,int sumg,int ge) {
		if(sumg>=sum/2) {
			if(sumg==sum/2) {
				min=Math.min(min, ge);
			}
			return;
		}
		for(int i=0;i<4;i++) {
			int xx=x+dx[i];
			int yy=y+dy[i];
			if(xx>=1&&yy>=1&&x<=n&&yy<=m&&v[xx][yy]==0) {
				v[xx][yy]=1;
				dfs(xx, yy, sumg+s[xx][yy], ge+1);
				v[xx][yy]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				s[i][j]=sc.nextInt();
				sum+=s[i][j];
			}
		}
		if(sum%2!=0) {
			System.out.println(0);
		}
		dfs(1, 1, s[1][1], 1);
		if(min==Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(min);
		}
	}
}
