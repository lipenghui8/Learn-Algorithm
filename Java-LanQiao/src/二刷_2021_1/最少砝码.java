package 二刷_2021_1;

import java.util.Scanner;

public class 最少砝码 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long sum=0L,i=0L;
		long N=sc.nextLong();
		while(sum<N) {
			sum+=Math.pow(3, i);
			i++;
		}
		System.out.println(i);
	}
}
