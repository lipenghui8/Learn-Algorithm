package t2021_1;

import java.math.BigInteger;

public class 货物摆放 {
	public static void main(String[] args) {
		long sum=0;
		String ss="2021041820210418";
		long s=Long.parseLong(ss);
		for(long i=1;i<=1000000;i++) {
			if(s%i!=0) {
				continue;
			}
			for(long j=i;j<=Math.sqrt(s)+1;j++) {
				if(s/i%j!=0) {
					continue;
				}
				long k=s/i/j;
				if(k<j) {
					continue;
				}
				if(i*j*k==s) {
					if(i==j&&i==k) {
						sum+=1;
					}else if(i!=j&&i!=k&&j!=k) {
						sum+=6;
					}else {
						sum+=3;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
