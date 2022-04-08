package 二刷_t2018;

import java.util.Arrays;
import java.util.Scanner;

public class 递增三元组 {
	static int[] a=new int[100010];
	static int[] b=new int[100010];
	static int[] c=new int[100010];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			b[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			c[i]=sc.nextInt();
		}
		Arrays.sort(a,0,n);
		Arrays.sort(b,0,n);
		Arrays.sort(c,0,n);
		long sum=0;
		for(int i=0;i<n;i++) {
			int p=0,q=0;
			for(p=0;p<n;p++) {
				if(a[p]>=b[i]) {
					break;
				}
			}
			for(q=0;q<n;q++) {
				if(c[q]>b[i]) {
					break;
				}
			}
			sum=sum+1L*p*(n-q);
		}
		System.out.println(sum);
	}
}
