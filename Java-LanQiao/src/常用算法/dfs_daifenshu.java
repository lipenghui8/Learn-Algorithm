package 常用算法;

import java.util.Scanner;

public class dfs_daifenshu {
	static int sum=0;
	static int n;
	static int []st=new int[30];
	static int []ans=new int[30];
	public static void dfs(int x) {
		if(x>9) {
//			for(int i=1;i<=9;i++) {
//				System.out.printf("%5d",ans[i]);
//			}
//			System.out.println();
			for(int i=1;i<=7;i++) {
				for(int j=i+1;j<=8;j++) {
					int a=0,b=0,c=0;
					for(int k=1;k<=i;k++) {
						a*=10;
						a+=ans[k];
					} 
					for(int k=i+1;k<=j;k++) {
						b*=10;
						b+=ans[k];
					}
					for(int k=j+1;k<=9;k++) {
						c*=10;
						c+=ans[k];
					}
					if(b%c!=0) {
						continue;
					}
					if((a+b/c)==n) {
						sum++;
					}
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
		n=sc.nextInt();
		dfs(1);
		System.out.println(sum);
	}
}
