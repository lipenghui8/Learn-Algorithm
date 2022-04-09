package lanqiao;

import java.math.BigInteger;
import java.util.Scanner;

public class t5 {
	static long k;
	static BigInteger sum=new BigInteger("1");
	static BigInteger sa=new BigInteger("1");
	static BigInteger mm=new BigInteger("10");
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		k=sc.nextLong();
//		int len=String.valueOf(k).length()-3;
//		if(k>1000) {
//			System.out.println(k*4+5*len);
//			return;
//		}
		
		BigInteger m=new BigInteger("10");
		BigInteger m1=m.pow((int)(k+1));
		m=m.pow((int)k);
		
		for(long i=2;i<=Long.MAX_VALUE;i++) {
			sa=sa.multiply(new BigInteger(String.valueOf(i))).mod(m1);
			sum=sa.mod(m);
			if(sum.toString()=="0") {
				if(sa.toString().charAt(0)=='0') {
					System.out.println(-1);
					break;
				}
				System.out.println(i);
				break;
			}
		}
	}
}
