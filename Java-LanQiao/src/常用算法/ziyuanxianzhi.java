package 常用算法;

import java.util.Scanner;

public class ziyuanxianzhi {
	static int m=0,n=0,k=0,sum=0;
	static int[][] st=new int[500][500];
	
	public static void dfs(int x,int y,int aa,int bb) {
		if(aa==0&&bb==0) {
			
			return;
		}
		if(aa!=0) {
			
		}
		if(bb!=0) {
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		n=sc.nextInt();
		k=(int) ((Math.sqrt(8*(m+n)+1)-1)/2);
		dfs(1,1,m,n);
		System.out.println(k);
	}
}
