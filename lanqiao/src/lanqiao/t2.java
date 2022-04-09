package lanqiao;

import java.util.Scanner;

public class t2 {
	static boolean check(long x) {
		char[] s=String.valueOf(x).toCharArray();
		int flag=0;
		int len=s.length;
		if(s[0]!=s[len-1]) {
			return false;
		}
		for(int i=1;i<len/2+1;i++) {
			if(s[i]>=s[i-1]&&s[i]==s[len-i-1]) {
				
			}else {
				flag=1;
				break;
			}
		}
		if(flag==1) {
			return false;
		}else {
			return true;
		}
	}
	public static void main(String[] args) {	
		long sum=0L;
		for(long i=2022;i<=2022222022;i++) {
			if(check(i)) {
				sum=sum+1L;
			}
		}
		System.out.println(sum+"----"+"3138");
	}
}
