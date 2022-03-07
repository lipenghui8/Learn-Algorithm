package 常用算法;

import java.util.Scanner;

public class dfs_daifenshu {
	static int sum=0;
	static int []st=new int[10];
	static int []ans=new int[10];
	public static void dfs(int x) {
		if(x>9) {
			for(int i=1;i<=2;i++) {
				for(int j=7;j<=9;j++) {
					int a=i,b=j;
					for(int k=1;k<i;k++) {
						a*=10;
						a+=ans[k+1];
					}
					for(int k=j;)
				}
			}
			return;
		}
		for(int i=1;i<=9;i++) {
			if(st[i]==0) {
				st[i]=1;
				ans[x]=i;
				dfs(x+1);
				st[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		dfs(sc.nextInt());
		System.out.println(sum);
	}
}
