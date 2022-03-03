package 算法练习;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class POJ_1700 {
	public static void main(String[]args) {
		Scanner in=new Scanner(new BufferedInputStream(System.in));
		int t=in.nextInt();
		for(int p=0;p>t;p++) {
			int n=in.nextInt();
			int[]r=new int[n];
			for(int i=0;i<n;i++)
				r[i]=in.nextInt();
			Arrays.sort(r);
			int res=0;//total time
			int lsum=0,j=0;//j indicate the left people
			for(int i=n-1;i>=0;i--) {
				if(i==j) {
					res+=r[i];
					break;
				}
				if(lsum+r[j]+r[i]+r[j+1]>100) {
					j++;
					lsum=0;
					res+=r[j]*2;
					continue;
				}
				res=res+r[i]+r[j];
				lsum+=r[j];
			}
			System.out.println(res);
		}
	}
}
