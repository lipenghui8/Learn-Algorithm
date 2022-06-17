package 重点练习;

import java.util.Scanner;

public class 剪格子 {
	static int[][] s=new int[11][11];
	static int[][] v=new int[11][11];
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int sums=0,m,n,res=Integer.MAX_VALUE;
	
	static void dfs(int x,int y,int sum,int cnt) {
		if(sum>=sums) {
			if(sum==sums&&cnt<res) {
				res=cnt;
			}
			return;
		}
		for(int i=0;i<4;i++) {
			int xx=x+dx[i],yy=y+dy[i];
			if(xx>=1&&xx<=n&&yy>=1&&yy<=m&&v[xx][yy]==0) {
				v[xx][yy]=1;
				dfs(xx, yy, sum+s[xx][yy], cnt+1);
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
				sums+=s[i][j];
			}
		}
		if(sums%2!=0) {
			System.out.println(0);
			return;
		}
		sums/=2;
		dfs(1,1,s[1][1],1);
		System.out.println(res);
	}
}
