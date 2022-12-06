package t202112;

import java.util.Scanner;

public class t2 {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),N=sc.nextInt();
		final int r=N/(n+1);
		int M=(int) (1e8);
		int []dif=new int[M];
		int []f=new int[M];
		for(int i=1;i<=n;i++) {
			dif[sc.nextInt()]++;
		}
		for(int i=1;i<N;i++) {
			f[i]=f[i-1]+dif[i];
		}
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=Math.abs(i/r-f[i]);
		}
		System.out.print(sum);
	}
}
