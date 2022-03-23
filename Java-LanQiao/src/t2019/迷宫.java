
package t2019;

import java.util.Scanner;

public class 迷宫 {
	static int p=30,q=50;
	static int[][] v=new int[100][100];
	static int[][] ansv=new int[100][100];
	static int[][] a=new int[100][100];
	static int min=Integer.MAX_VALUE;
	static char[] ans= {'D','U','L','R'};
	static void dfs(int x,int y,int step) {
		if(x>30||y>50||x<1||y<1) {
			return;
		}
		if(x==p&&y==q) {
			if(step<min) {
				min=step;
				ansv=v;
			}
			return;
		}
		//下
		if(a[x+1][y]==0&&v[x+1][y]==0) {
			v[x+1][y]=1;
			dfs(x+1,y,step+1);
			v[x+1][y]=0;
		}
		//左
		if(a[x][y-1]==0&&v[x][y-1]==0) {
			v[x][y-1]=1;
			dfs(x,y-1,step+1);
			v[x][y-1]=0;
		}
		//右
		if(a[x][y+1]==0&&v[x][y+1]==0) {
			v[x][y+1]=1;
			dfs(x,y+1,step+1);
			v[x][y+1]=0;
		}
		//上
		if(a[x-1][y]==0&&v[x-1][y]==0) {
			v[x-1][y]=1;
			dfs(x-1,y,step+1);
			v[x-1][y]=0;
		}
		return;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss="";
		for(int i=1;i<=30;i++) {
			ss+=sc.nextLine();
		}
		char[] as=ss.toCharArray();
		for(int i=1;i<=30;i++) {
			for(int j=1;j<=50;j++) {
				a[i][j]=(as[50*(i-1)+j-1]-48);
			}
		}
		dfs(1,1,0);
		for(int i=1;i<=30;i++) {
			for(int j=1;j<=50;j++) {
				System.out.print(v[i][j]);
			}
			System.out.println();
		}
		System.out.println(min);
	}
}
