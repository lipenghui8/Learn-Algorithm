package 二刷_2020_2;

import java.util.Arrays;
import java.util.Scanner;

public class 子串分值和 {
	static long sum=0L;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.nextLine();
		char[] s=ss.toCharArray();
		int len=s.length;
		for(int i=0;i<len;i++) {
			int cnt=0;
			boolean[] res=new boolean[26];
			for(int j=0;j<len-i;j++) {
				int k=(int)(s[i+j]-'a');
				if(!res[k]) {
					res[k]=true;
					cnt++;
				}
				sum+=(int)(cnt);
			}
		}
		System.out.println(sum);
	}
}
