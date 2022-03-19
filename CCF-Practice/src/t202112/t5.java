package t202112;

import java.util.Scanner;

public class t5 {
	static int M=((int) (1e6+10));
	static int[][] a=new int[M][M];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),k1=sc.nextInt(),k2=sc.nextInt();
		for(int i=1;i<n;i++) {
			int x=sc.nextInt(),y=sc.nextInt();
			if(x>=y) {
				a[x][y]=1;
			}else {
				a[y][x]=1;
			}
		}
		
	}
}
