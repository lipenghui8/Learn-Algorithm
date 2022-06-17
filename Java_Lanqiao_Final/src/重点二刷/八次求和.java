package 重点二刷;

import java.util.Scanner;

public class 八次求和 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Long res=0L;
		for(int i=1;i<=n;i++) {
			Long r1=1L;
			for(int j=1;j<=8;j++) {
				r1=(r1*i)%123456789;
			}
			res=(res+r1)%123456789;
		}
		System.out.println(res);
	}
}
