package 算法练习;

import java.io.BufferedInputStream;
import java.util.Scanner;

class POJ_1995 {
	public static long quick_pow(long a,long b,long c) {
		long ans=1;
		a=a%c;
		while(b>0) {
			if(b%2==1) ans=(ans*a)%c;
			b>>=1;
			a=(a*a)%c;
		}
		return ans;
	}
	public static void main(String[]args) {
		Scanner in=new Scanner(new BufferedInputStream(System.in));
		int z=in.nextInt();
		for(int i=0;i<z;i++) {
			int m=in.nextInt();
			int h=in.nextInt();
			long res=0; 
			for(int j=0;j<h;j++) {
				long a=in.nextLong();
				long b=in.nextLong();
				res+=quick_pow(a, b, m);
			}
			System.out.println(res%m);
		}
	}
}
