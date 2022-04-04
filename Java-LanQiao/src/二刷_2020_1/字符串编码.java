package 二刷_2020_1;

import java.util.Scanner;

public class 字符串编码 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.nextLine();
		char[] s=ss.toCharArray();
		for(int i=0;i<s.length;i++) {
			int p=s[i]-48;
			int q=0;
			if(i<s.length-1) {
				q=s[i+1]-48;
			}
			if(i<s.length-2&&(s[i+2]-48)==0) {
				System.out.print((char)('A'+p-1));
			}else if(i<s.length-1&&p*10+q<=26) {
				System.out.print((char)('A'+p*10+q-1));
				i++;
			}else {
				System.out.print((char)('A'+p-1));
			}
		}
	}
}
