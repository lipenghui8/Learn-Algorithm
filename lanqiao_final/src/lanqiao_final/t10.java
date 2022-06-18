package lanqiao_final;

import java.util.Scanner;

public class t10 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long l=sc.nextLong(),r=sc.nextLong();
		long sum=0;
		for(long i=l;i<=r;i++) {
			String string=String.valueOf(i);
			if(string.contains("2022")) {
				sum+=i;
			}
		}
		System.out.println(sum);
	}
}
