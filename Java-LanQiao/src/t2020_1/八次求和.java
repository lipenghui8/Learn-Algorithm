package t2020_1;

import java.math.BigInteger;
import java.util.Scanner;

public class 八次求和 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		BigInteger sum=BigInteger.ZERO;
		BigInteger s=new BigInteger("123456789");
		for(int i=1;i<=n;i++) {
			BigInteger p=new BigInteger(Integer.toString(i));
			p=p.pow(8);
			sum=sum.add(p);
			sum=sum.mod(s);
		}
		System.out.println(sum.toString());
	}
}
