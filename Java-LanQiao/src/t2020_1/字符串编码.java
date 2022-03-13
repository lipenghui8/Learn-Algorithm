package t2020_1;

import java.util.Scanner;

public class 字符串编码 {
	public static void main(String[] args) {
		char[] s=new char[27];
		for(int i=1;i<=26;i++) {
			s[i]=((char)(65+i-1));
		}
		Scanner sc=new Scanner(System.in);
		String n=sc.next();
		int len=n.length();
		int[] m=new int[len];
		for(int i=0;i<len;i++) {
			m[i]=(int)(n.charAt(i))-48;
		}
		char[] q=new char[len];
		int j=0;
		for(int i=0;i<len;i++) {
			int r=m[i]*10+m[i+1];
			if(i<len-1&&r<=26) {
				q[j]=((char)('A'+(r-1)));
				i++;
			}
			else {
				q[j]=((char)('A'+(m[i]-1)));
			}
			j++;
		}
		
		for(int i=0;i<j;i++) {
			System.out.print(q[i]);
		}
		
	}
}
