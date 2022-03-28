package t2021_1;

import java.util.Scanner;

public class 最少砝码 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long sum=0,i=0;
		while(sum<n) {
			sum+=Math.pow(3, i);
			i++;
		}
		System.out.println(i);
	}
}
