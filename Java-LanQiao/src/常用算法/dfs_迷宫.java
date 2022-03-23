package 常用算法;

import java.util.Scanner;

public class dfs_迷宫 {
	static int m,n;//迷宫大小
	static int p=4,q=3;//终点坐标
	static int min=Integer.MAX_VALUE;//最小步数
	static int[][] a=new int[100][100];  //1表示空地，2表示障碍
//	1 1 2 1
//	1 1 1 1
//	1 1 2 1 
//	1 2 1 1
//	1 1 1 2
	static int[][] v=new int[100][100];
	static void dfs(int x,int y,int step) {
		if(x==p&&y==q) {//处理终点情况
			if(step<min) {
				min=step;
			}
			return;
		}
		//顺时针试探
		//右
		if(a[x][y+1]==1&&v[x][y+1]==0) {
			v[x][y+1]=1;
			dfs(x,y+1,step+1);
			v[x][y+1]=0;
		}
		//下
		if(a[x+1][y]==1&&v[x+1][y]==0) {
			v[x+1][y]=1;
			dfs(x+1,y,step+1);
			v[x+1][y]=0;
		}
		//左
		if(a[x][y-1]==1&&v[x][y-1]==0) {
			v[x][y-1]=1;
			dfs(x,y-1,step+1);
			v[x][y-1]=1;
		}
		//上
		if(a[x-1][y]==1&&v[x-1][y]==0) {
			v[x-1][y]=1;
			dfs(x-1,y,step+1);
			v[x-1][y]=0;
		}
		return;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		n=sc.nextInt();
		//输入迷宫数据
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		v[1][1]=1;
		dfs(1,1,0);
		System.out.println(min);
	}
}
