package t202112;

import java.util.Scanner;

public class t1 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);//键盘输入
		int n=sc.nextInt();
		int N=sc.nextInt();
		int M=(int) (1e7+5);
		int []f=new int[M];
		int []dif=new int[M];
		
		for(int i=1;i<=n;i++) {
			dif[sc.nextInt()]++;
		}
		int sum=0;
		for(int i=1;i<N;i++) {
			f[i]=f[i-1]+dif[i];
			sum+=f[i];
		}
		
//		for(int i=0;i<=n;i++) {
//			System.out.print(dif[i]+" ");
//		}
//		System.out.println();
//		for(int i=0;i<N;i++) {
//			System.out.print(f[i]+" ");
//		}
//		System.out.println();
		System.out.print(sum);
	}
}
