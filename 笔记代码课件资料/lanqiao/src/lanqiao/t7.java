package lanqiao;

import java.util.Scanner;

public class t7 {
	static int[] s=new int[10005];
	static int n;
	static long cnt=0L;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			s[i]=sc.nextInt();
		}
		for(int i=1;i<=n;i++) {
			int min=s[i];
			int max=s[i];
			long sum=1L;
			for(int j=i;j<=n;j++) {
				if(s[j]<min-1||s[j]>max+1) {
					break;
				}
				if(s[j]>max) {
					max=s[j];
				}
				if(s[i]<min) {
					min=s[j];
				}
				sum++;
			}
			cnt+=sum;
		}
		System.out.println(cnt/2);
	}
}
