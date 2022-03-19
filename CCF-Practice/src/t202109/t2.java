package t202109;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.function.IntFunction;

public class t2 {	
	static int N=((int) (1e6+10));
	static int[] a=new int[N];
	static int[] b=new int[N];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int len=1;
		int y=sc.nextInt();
		a[len]=y;
		len++;
		for(int i=2;i<=n;i++) {
			int x=sc.nextInt();
			if(x==y) {
				continue;
			}else {
				y=x;
				a[len]=x;
				len++;
			}
		}
		for(int i=1;i<len;i++) {
			if(a[i]>a[i-1]&&a[i]>a[i+1]) {
				b[a[i]]++;
			}else if(a[i]<a[i-1]&&a[i]<a[i+1]) {
				b[a[i]]--;
			}
		}
		int max=Integer.MIN_VALUE,sum=0;
		for(int i=10000;i>=1;i--) {
			sum+=b[i];
			max=Math.max(max, sum);
		}
		System.out.println(max);
	}
}
