package 前缀合和差分练习;

import java.util.Scanner;

public class 城市传送 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt();
		int[] a=new int[n]; 
		for(int i=1;i<=n-1;i++) {
			a[i]=sc.nextInt();
			a[i]+=a[i-1];
		}
		int max=0;
		for(int i=1;i<=n-1;i++) {
			int p=i+k;
			if(p>n)p=n;
			max=Math.max(max, a[p-1]-a[i-1]);
		}
		System.out.println(a[n-1]-max);
	}
}
