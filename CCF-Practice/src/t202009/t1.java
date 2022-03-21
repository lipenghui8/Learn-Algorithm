package t202009;

import java.util.Arrays;
import java.util.Scanner;

public class t1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt();
		int[] d=new int[10000000];
		for(int i=1;i<=n;i++) {
			int x1=sc.nextInt(),y1=sc.nextInt();
			d[i]=(int) (Math.pow((x-x1), 2)+Math.pow(y-y1, 2));
		}
		Arrays.sort(d,1,n+1);
		
		int min1=0,d1=Integer.MAX_VALUE,min2=0,d2=Integer.MAX_VALUE,min3=0,d3=Integer.MAX_VALUE;
		for(int i=1;i<=n;i++) {
			
		}
		System.out.println(min1);
		System.out.println(min2);
		System.out.println(min3);
	}
}
