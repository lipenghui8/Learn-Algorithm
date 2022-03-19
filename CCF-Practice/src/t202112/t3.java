package t202112;

import java.util.Scanner;

import javax.swing.text.html.parser.DTDConstants;

public class t3 {
	static int[] b=new int[10100];
	static int[] c=new int[10100];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int w=sc.nextInt(),s=sc.nextInt();
		String aa=sc.next();
		char[] a=aa.toCharArray();
		int len=a.length;
		for(int i=0;i<len;i++) {
			if(a[i]>='a'&&a[i]<='z') {
				b[i]=(a[i]-'a');
			}
			else if(a[i]>='A'&&a[i]<='Z') {
				b[i]=(a[i]-'A');
			}
		}
		int j=0;
		for(int i=0;i<len-1;i++) {
			c[j]=b[i]*30+b[i+1];
			i++;
			j++;
		}
		if(len%2==1) {
			c[j]=900;
		}
		int nc=(int) Math.ceil(len/1.0/2);
		System.out.println(w);
		for(int i=0;i<nc;i++) {
			System.out.println(c[i]);
		}
		for(int i=0;i<(w-1-nc);i++) {
			System.out.println(900);
		}
	}
}
