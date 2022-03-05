package t202109;

import java.util.Scanner;

public class t1 {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int max=0,min=0;
		int p,q;
		q=sc.nextInt();
		max=min=q;
		for(int i=2;i<=n;i++) {
			p=sc.nextInt();
			if(p>q) {
				min+=p;
			}
			max+=p;
			q=p;
		}
		System.out.println(max);
		System.out.println(min);
	}
}
