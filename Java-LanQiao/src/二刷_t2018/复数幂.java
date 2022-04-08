package 二刷_t2018;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

public class 复数幂 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter out=new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\86155\\eclipse-workspace\\res1.txt")));
		BigInteger a=new BigInteger("2");
		BigInteger b=new BigInteger("3");
		BigInteger c=new BigInteger("2");
		BigInteger d=new BigInteger("3");
		for(int i=2;i<=123456;i++) {
			BigInteger p=a,q=b;;
			a=p.multiply(c).subtract(q.multiply(d));
			b=p.multiply(d).add(q.multiply(c));
		}
//		out.write(a.toString()+b.toString()+"i");
		out.print(a.toString()+b.toString()+"i");
		out.close();
	}
}
