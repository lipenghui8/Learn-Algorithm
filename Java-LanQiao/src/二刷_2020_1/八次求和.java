package 二刷_2020_1;

import java.util.Scanner;

public class 八次求和 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Long n=sc.nextLong();
		Long res=0L;
		for(int i=1;i<=n;i++) {
			res=(res+(int)Math.pow(i, 8))%123456789;
		}
		System.out.println(res);
	}
}
