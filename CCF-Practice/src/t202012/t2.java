
package t202012;

import java.util.Scanner;

public class t2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int M=(int) 1e8;
		int[] s=new int[M];
		int m=sc.nextInt();
		int sum1=0;int max=0;
		for(int i=1;i<=m;i++) {
			int a=sc.nextInt(),b=sc.nextInt();
			s[a]=b;
			if(b==1)sum1++;
			max=Math.max(a, max);
		}
		for(int i=1;i<=max;i++) {
			s[i]+=s[i-1];
		}
		for(int i=1;i<=max;i++) {
			
		}
	}
}
