package 二刷_2021_1;

import java.util.Scanner;

public class 杨辉三角形_100分 {
	static int n;
	static long C(int a,int b) {
		long res=1L;
		for(int i=a,j=1;j<=b;i--,j++) {
			res=res*i/j;
			if(res>n) {
				return res;
			}
		}
		return res;
	}
	static boolean check(int k) {
		//对斜行进行二分查找
		int l=2*k,r=Math.max(n, l);
		while(l<r) {
			int mid=l+r>>1;
			if(C(mid, k)>=n) {
				r=mid;
			}else {
				l=mid+1;
			}
		}
		if(C(r,k)!=n) {
			return false;
		}
		System.out.println(r*(r+1)/2+k+1);
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(int i=16;;i--) {
			if(check(i)) {
				break;
			}
		}
	}
}
