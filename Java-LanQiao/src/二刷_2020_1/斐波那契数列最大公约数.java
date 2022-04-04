package 二刷_2020_1;

import java.math.BigInteger;

public class 斐波那契数列最大公约数 {
//	static long f(int x) {
//		long p=1,q=1,res=0;
//		for(int i=3;i<=x;i++) {
//			res=p+q;
//			p=q;
//			q=res;
//		}
//		return res;
//	}
	static BigInteger f(int x) {
		BigInteger p=new BigInteger("1");
		BigInteger q=new BigInteger("1");
		BigInteger res=new BigInteger("0");
		for(int i=3;i<=x;i++) {
			res=p.add(q);
			p=q;
			q=res;
		}
		return res;
	}
	static BigInteger gcd(BigInteger a,BigInteger b) {
		return b.equals(new BigInteger("0"))?a:gcd(b, a.mod(b));
	}
	public static void main(String[] args) {
		BigInteger a=f(2020);
		BigInteger b=f(520);
		BigInteger res=gcd(a, b);
		System.out.println(res);
	}
}
