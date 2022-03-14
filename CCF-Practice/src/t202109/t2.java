package t202109;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.function.IntFunction;

public class t2 {
	static int n;
	
	public static Object[] clear(Object[] arr) {
		LinkedHashSet<Object> temp=new LinkedHashSet<>();
		for(int i=1;i<=n;i++) {
			temp.add(arr[i]);
		}
		return temp.toArray();
	}
	
	public static void main(String[] args) {
		int N=500000;
		int M=10000;
		int[] a=new int[N+2];
		Object[] as=new Object[N+2];
		int[] d=new int[M+1];
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			as[i]=sc.nextInt();
		}
		as[0]=as[n+1]=0;
		Object[] aa=clear(as);
		n=aa.length;
		for(int i=1;i<=n;i++) {
			a[i]=Integer.parseInt(aa[i-1].toString());
		}
		a[0]=a[n+1]=0;
		for(int i=0;i<=n+1;i++) {
			System.out.print(a[i]+" ");
		}
		
		for(int i=1;i<n;i++) {
			if(a[i-1]<a[i]&&a[i]>a[i+1]) {
				d[a[i]]++;
			}
			else if(a[i-1]>a[i]&&a[i]<a[i+1]){
				d[a[i]]--;
			}
		}
		
		int ans=0,sum=0;
		for(int i=M;i>=1;i--) {
			sum+=d[i];
			ans=Math.max(ans, sum);
		}
//		System.out.println(ans);
	}
}
