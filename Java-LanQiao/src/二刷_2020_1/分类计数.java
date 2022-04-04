package 二刷_2020_1;

import java.util.Scanner;

public class 分类计数 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		char[] ss=s.toCharArray();
		int a=0,b=0,c=0;
		for(int i=0;i<ss.length;i++) {
			if(ss[i]>='A'&&ss[i]<='Z') {
				a++;
			}else if(ss[i]>='a'&&ss[i]<='z') {
				b++;
			}else if(ss[i]>='0'&&ss[i]<='9') {
				c++;
			}
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
