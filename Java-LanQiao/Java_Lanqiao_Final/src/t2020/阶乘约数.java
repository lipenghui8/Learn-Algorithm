package t2020;

import java.math.BigInteger;

public class 阶乘约数 {
	public static void main(String[] args) {
		BigInteger res=new BigInteger("1");
		BigInteger k=new BigInteger("1");
		for(int i=1;i<=100;i++) {
			res=res.multiply(k);
			k=k.add(new BigInteger("1"));
		}
		System.out.println(res);
		BigInteger i=new BigInteger("1");
		BigInteger p=res.divide(new BigInteger("2"));
		long cnt=0;
		while(i.compareTo(p)!=0) {
			if(res.mod(i).equals(0)) {
				cnt++;
			}
			i=i.add(new BigInteger("1"));
		}
		System.out.println(cnt+1);
	}
}
