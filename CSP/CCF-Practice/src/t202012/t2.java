package t202012;

import java.util.Scanner;

public class t2 {
	static int M=((int) (1e8+10));
	static int a[]=new int[M];
	static long err=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),N=sc.nextInt();
		long r=((int) Math.floor(N/1.0/(n+1)));
		for(int i=1;i<=n;i++) {
			int x=sc.nextInt();
			if(x>=N) {
				x=N;
			}
			a[x]++;
		}
		long f=0,g=0;
		for(int i=0;i<N;i++) {
			f+=a[i];
			g=((int) Math.floor(i/1.0/r));
			err+=(Math.abs(f-g));
		}
		System.out.println(err);
	}
}
