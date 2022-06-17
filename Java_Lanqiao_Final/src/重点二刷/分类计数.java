package 重点二刷;

import java.util.Scanner;

public class 分类计数 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.nextLine();
		char[] s=ss.toCharArray();
		int a=0,b=0,c=0;
		for(int i=0;i<s.length;i++) {
			if(s[i]>='A'&&s[i]<='Z') {
				a++;
			}
			else if(s[i]>='a'&&s[i]<='z') {
				b++;
			}
			else if(s[i]>='0'&&s[i]<='9') {
				c++;
			}
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
