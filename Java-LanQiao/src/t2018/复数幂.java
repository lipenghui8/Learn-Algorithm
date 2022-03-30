package t2018;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

public class 复数幂 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter out=new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\86155\\eclipse-workspace\\Java-LanQiao\\src\\t2018\\mi.txt")));
		BigInteger ansa=new BigInteger("2"),ansb=new BigInteger("3");
		BigInteger tempa,tempb;
		BigInteger c=new BigInteger("2"),d=new BigInteger("3");
		for(int i=2;i<=123456;i++) {
			tempa=ansa.multiply(c).subtract(ansb.multiply(d));
			tempb=ansa.multiply(d).add(ansb.multiply(c));
			ansa=tempa;
			ansb=tempb;
		}
		out.println(ansa.toString()+ansb.toString());
		out.close();
	}
}
