package t2021;

import java.util.Scanner;

public class 大写 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.nextLine();
		char[] s=ss.toCharArray();
		for(int i=0;i<s.length;i++) {
			if(s[i]>='a'&&s[i]<='z') {
				s[i]=(char) (s[i]-'a'+'A');
			}
		}
		System.out.println(s);
	}
}
