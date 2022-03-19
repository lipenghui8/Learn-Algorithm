package t202112;

import java.util.Scanner;

public class t4 {
	static Scanner sc=new Scanner(System.in);
	static int M=((int) (1e8+10));
	static int[][] a=new int[3][M];
	public static void main(String[] args) {
		int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
		int p;
		for(int i=1;i<=k;i++) {
			p=sc.nextInt();
			if(p==0) {
				int id=sc.nextInt(),l=sc.nextInt(),r=sc.nextInt(),x=sc.nextInt();
				int j=l;
				for(j=l;j<=r;j++) {
					if(a[2][j]==0) {
						a[0][j]=id;
						a[1][j]=x;
						a[2][j]=1;
					}
					else if(a[0][j]==id) {
						a[1][j]=x;
						a[2][j]=1;
					}
					else if(a[0][j]!=id) {
						break;
					}
				}
				if(j==l) {
					System.out.println(-1);
				}else {
					System.out.println(j-1);
				}
			}
			else if(p==3){
				int x=sc.nextInt();
				if(a[2][x]==0) {
					System.out.println("0 0");
				}else {
					System.out.println(a[0][x]+" "+a[1][x]);
				}
			}
			else if(p==1) {
				int id=sc.nextInt(),l=sc.nextInt(),r=sc.nextInt();
				int q=1;
				for(int j=l;j<=r;j++) {
					if(a[0][j]!=id||a[2][j]==0) {
						q=0;
					}
				}
				if(q==1) {
					for(int j=l;j<=r;j++) {
						a[2][j]=0;
					}
					System.out.println("OK");
				}else {
					System.out.println("FAIL");
				}
			}
			else {
				int id=sc.nextInt(),l=sc.nextInt(),r=sc.nextInt();
				int q=1;
				for(int j=l;j<=r;j++) {
					if(a[2][j]!=0||a[0][j]!=id) {
						q=0;
					}
				}
				if(q==0) {
					System.out.println("FAIL");
					break;
				}
				System.out.println("OK");
				for(int j=l;j<=r;j++) {
					a[2][j]=1;
				}
			}
		}
	}
}
