package lanqiao;

import java.math.BigInteger;

public class t1 {
	public static void main(String[] args) {
		BigInteger s=new BigInteger("20");
//		System.out.println(s.pow(22));
		System.out.println(s.pow(22).mod(new BigInteger("7")));
	}
}
