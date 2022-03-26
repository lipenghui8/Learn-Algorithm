package t2020_2;

import java.util.Scanner;

public class 数字三角形 {
	static int[][] s=new int[200][200];
	static int n;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				s[i][j]=sc.nextInt();
				s[i][j]+=Math.max(s[i-1][j-1],s[i-1][j]);
			}
		}
		if(n%2==1) {
			System.out.println(s[n][n/2+1]);
		}else {
			System.out.println(Math.max(s[n][n/2], s[n][n/2+1]));
		}		
	}
}
