package 重点二刷;

import java.math.BigInteger;

public class 斐波那契数列最大公约数 {
	static BigInteger gcd(BigInteger a,BigInteger b) {
		return b.equals(0)?a:gcd(b,a.mod(b));
	}
	static BigInteger f(int n) {
		BigInteger a=BigInteger.ONE,b=BigInteger.ONE;
		BigInteger res=BigInteger.ZERO;
		for(int i=3;i<=n;i++) {
			res=a.add(b);
			a=b;
			b=res;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(f(2020).gcd(f(520)));
	}
}
