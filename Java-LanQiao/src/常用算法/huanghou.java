package 常用算法;

import java.util.Iterator;
import java.util.Scanner;

public class huanghou {
	static int[] st1=new int[30];//记录每一行是否被访问
	static int[] st2=new int[30];//记录每一列是否被访问
	static int[] st3=new int[30];//记录左斜线
	static int[] st4=new int[30];//记录右斜线
	static int[] ans=new int[30];//记录结果
	static int n;
	public static void dfs(int x) {
		if(x>n) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(ans[i]==j) {
						System.out.print("Q");
					}else {
						System.out.print(".");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) {
			if(st1[x]==0&&st2[i]==0&&st3[x+i-1]==0&&st4[n-i+x+1]==0) {
				st1[x]=st2[i]=st3[x+i-1]=st4[n-i+x+1]=1;
				ans[x]=i;
				dfs(x+1);
				st1[x]=st2[i]=st3[x+i-1]=st4[n-i+x+1]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		dfs(1);
	}
}
