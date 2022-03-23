package t2019;

import java.util.Scanner;

import org.jcp.xml.dsig.internal.dom.ApacheTransform;

public class 组队 {
	static int max=Integer.MIN_VALUE;
	static int[] ans=new int[30];
	static int[][] a=new int[30][30];
	static int[] st=new int[30];
	static void dfs(int x) {
		if(x>5) {
			int sum=0;
			for(int i=1;i<=5;i++) {
				sum+=ans[i];
			}
			if(sum>max) {
				max=sum;
			}
			return;
		}
		for(int i=1;i<=20;i++) {
			if(st[i]==0) {
				st[i]=1;
				ans[x]=a[i][x];
				dfs(x+1);
				st[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=1;i<=20;i++) {
			for(int j=1;j<=5;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		dfs(1);
		System.out.println(max);
	}
}
