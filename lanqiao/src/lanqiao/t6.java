package lanqiao;

import java.util.Scanner;

public class t6 {
	static int[][] s=new int[81][100001];
	static int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
	static int n,m,ll;
	static boolean check(int x1,int y1,int x2,int y2) {
		max=Integer.MIN_VALUE;
		min=Integer.MAX_VALUE;
		for(int i=x1;i<=x2;i++) {
			for(int j=y1;j<=y2;j++) {
				if(s[i][j]>max) {
					max=s[i][j];
				}
				if(s[i][j]<min) {
					min=s[i][j];
				}
			}
		}
		if(max-min<=ll) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				s[i][j]=sc.nextInt();
				if(s[i][j]>max) {
					max=s[i][j];
				}
				if(s[i][j]<min) {
					min=s[i][j];
				}
			}
		}
		ll=sc.nextInt();
		if(max-min<=ll) {
			System.out.println(n*m);
		}
		int cnt=0;
		for(int x1=1;x1<=n;x1++) {
			if((n-x1+1)*m<=cnt) {
				break;
			}
			for(int y1=1;y1<=m;y1++) {
				if((n-x1+1)*(m-y1+1)<=cnt) {
					break;
				}
				for(int x2=x1;x2<=n;x2++) {
					if((x2-x1+1)*(m-y1+1)<=cnt) {
						break;
					}
					for(int y2=y1;y2<=m;y2++) {
						int p=(x2-x1+1)*(y2-y1+1);
						if(p<=cnt) {
							continue;
						}
						if(check(x1,y1,x2,y2)) {
							cnt=p;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
