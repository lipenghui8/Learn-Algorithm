package t202012;

import java.util.Scanner;

public class t1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=sc.nextInt()*sc.nextInt();
		}
		System.out.println(Math.max(0, sum));
	}
}
