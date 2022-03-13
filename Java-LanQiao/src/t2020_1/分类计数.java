package t2020_1;

import java.util.Scanner;

public class 分类计数 {
	public static void main(String[] args) {
		String a;
		Scanner sc=new Scanner(System.in);
		a=sc.next();
		int sum1=0,sum2=0,sum3=0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)>='A'&&a.charAt(i)<='Z') {
				sum1++;
			}
			else if(a.charAt(i)>='a'&&a.charAt(i)<='z') {
				sum2++;
			}
			else if(a.charAt(i)>='0'&&a.charAt(i)<='9') {
				sum3++;
			}
		}
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
	}
}
