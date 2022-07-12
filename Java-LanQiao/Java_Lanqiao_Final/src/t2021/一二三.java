package t2021;

import java.util.Scanner;

public class 一二三 {
	static long f(long x) {
		if(x==0)return 0;
		long l=1,r=10000000,mid=0;
		while(l<r) {
			mid=(l+r+1)>>1;
			if(mid*(mid+1)/2<=x) {
				l=mid;
			}else{
				r=mid-1;
			}
		}
		long sum=(r*(1+r)/2+r*(1+r)*(1+2*r)/6)/2;
		long y=x-r*(1+r)/2;
		sum+=y*(1+y)/2;
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			long l=sc.nextLong();
			long r=sc.nextLong();
			long ans=f(r)-f(l-1);
			System.out.println(ans);
		}
	}
}
