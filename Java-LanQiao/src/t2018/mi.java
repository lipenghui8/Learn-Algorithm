package t2018;

import java.math.BigInteger;

public class mi {
	public static void main(String[] args) {
		BigInteger ansa=new BigInteger("2"),ansb=new BigInteger("3");
		BigInteger tempa,tempb;
		BigInteger c=new BigInteger("2"),d=new BigInteger("3");
		for(int i=2;i<=123456;i++) {
			tempa=ansa.multiply(c).subtract(ansb.multiply(d));
			tempb=ansa.multiply(d).add(ansb.multiply(c));
			ansa=tempa;
			ansb=tempb;
		}
		System.out.println(ansa.toString());
		System.out.println(ansb.toString());
	}
}
