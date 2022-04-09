package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class t4 {
	static int[] s=new int[100020];
	static int[] ss=new int[100020];
	static int n;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			s[i]=sc.nextInt();
			ss[i]=s[i];
		}
		Arrays.sort(s,1,n+1);
		int key=s[n/2+1];
		int i;
		for(i=1;i<n;i++) {
			if(ss[i]>=key) {
				System.out.print(0+" ");
			}else {
				System.out.print(key-ss[i]+1+" ");
			}
		}
		if(ss[i]>=key) {
			System.out.print(0);
		}else {
			System.out.print(key-ss[i]+1);
		}
	}
}
