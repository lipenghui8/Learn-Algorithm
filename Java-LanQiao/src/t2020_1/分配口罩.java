package t2020_1;

import java.util.Scanner;

import 常用算法.dfs;

public class 分配口罩 {
	public static int[] a={ 0, 9090400, 8499400, 5926800, 8547000, 4958200, 4422600, 5751200, 
			4175600, 6309600, 5865200, 6604400, 4635000,
			10663400, 8087200, 4554000 };
	static int sum=0,n=a.length-1,min=Integer.MAX_VALUE;
	public static int[] st=new int[n+1];
	
	public static void dfs(int x) {
		if(x>=sum/2) {
			min=Math.min(min, x);
			return;
		}
		for(int i=1;i<=n;i++) {
			if(st[i]==0) {
				st[i]=1;
				dfs(x+a[i]);
				st[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		for(int i=1;i<=n;i++) {
			sum+=a[i];
		}
		dfs(0);
		System.out.println(min*2-sum);
	}
}
