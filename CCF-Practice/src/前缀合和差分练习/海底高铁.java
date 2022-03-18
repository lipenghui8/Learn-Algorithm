package 前缀合和差分练习;

import java.util.Scanner;

public class 海底高铁 {
	static int M=100010;
	static long[] b=new long[M];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int x,y;
		x=sc.nextInt();
		for(int i=2;i<=m;i++) {
			y=sc.nextInt();
			if(x>y) {
				b[x]--;
				b[y]++;
			}
			else {
				b[x]++;
				b[y]--;
			}
			x=y;
		}
		for(int i=1;i<n;i++) {
			b[i]=b[i]+b[i-1];
		}
		long sum=0;
		for(int i=1;i<n;i++) {
			int p=sc.nextInt(),q=sc.nextInt(),r=sc.nextInt();
			sum+=Math.min(b[i]*p, b[i]*q+r);
		}
		System.out.println(sum);
	}
}
