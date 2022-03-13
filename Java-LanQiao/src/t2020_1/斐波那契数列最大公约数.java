package t2020_1;

import java.math.BigInteger;

public class 斐波那契数列最大公约数 {
	public static void main(String[] args) {
		BigInteger p=new BigInteger("1");
		BigInteger q=new BigInteger("1");
		BigInteger sum1=new BigInteger("0");
		for(int i=3;i<=520;i++) {
			sum1=p.add(q);
			p=q;
			q=sum1;
		}
		
		p=new BigInteger("1");
		q=new BigInteger("1");
		BigInteger sum2=new BigInteger("0");
		for(int i=3;i<=2020;i++) {
			sum2=p.add(q);
			p=q;
			q=sum2;
		}
		System.out.println(sum2.gcd(sum1));
	}
}
