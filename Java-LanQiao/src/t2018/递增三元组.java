package t2018;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 递增三元组 {
	static long sum=0;
	public static void main(String[] args) throws IOException {
//		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
//		int n=Integer.parseInt(in.readLine());
//		String sa=in.readLine(),sb=in.readLine(),sc=in.readLine();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		int[] b=new int[n];
		int[] c=new int[n];
//		String[] ssa=sa.split(" ");
//		String[] ssb=sb.split(" ");
//		String[] ssc=sc.split(" ");
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			b[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			c[i]=sc.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		for(int i=0;i<n;i++) {
			int p=0,q=0;
			while(p<n&&a[p]<b[i]) {
				p++;
			};
			while(q<n&&c[q]<=b[i]) {
				q++;
			}
			sum+=1L*(p)*(n-q);
		}
		System.out.println(sum);
	}
}
