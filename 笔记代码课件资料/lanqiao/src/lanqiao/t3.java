package lanqiao;

import java.util.Scanner;

public class t3 {
	static char[] cnt=new char[27];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.nextLine();
		char[] s=ss.toCharArray();
		int max=Integer.MIN_VALUE;
		for(int i=0;i<s.length;i++) {
			cnt[s[i]-'A']++;
			if(cnt[s[i]-'A']>max) {
				max=cnt[s[i]-'A'];
			}
		}
		for(int i=0;i<26;i++) {
			if(cnt[i]==max) {
				System.out.print((char)(i+'A'));
			}
		}
	}
}
