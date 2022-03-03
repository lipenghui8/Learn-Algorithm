package 算法练习;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class POJ_1425 {
	public static void main(String[]args) {
		Scanner in=new Scanner(new BufferedInputStream(System.in));
		int n=in.nextInt();
		int m=in.nextInt();
		int[]res=new int[n];
		for(int i=0;i<n;i++) {
			res[i]=in.nextInt();
		}
		Arrays.sort(res);
		for(int j=0;j<m;j++) {
			System.out.println(res[n-j-1]);
		}
	}
}
