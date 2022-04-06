package 二刷_2020_2;

import java.util.Arrays;
import java.util.Scanner;

public class 单词分析 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.nextLine();
		char[] s=ss.toCharArray();
		Arrays.sort(s);
		int max=Integer.MIN_VALUE;
		char res=s[0];
		int p=1;
		for(int i=1;i<s.length;i++) {
			if(s[i]==s[i-1]) {
				p++;
			}else {
				p=1;
			}
			if(p>max) {
				max=p;
				res=s[i];
			}
		}
		System.out.println(res);
		System.out.println(max);
	}
}
