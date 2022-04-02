package t2018;

import java.util.Scanner;

public class 日志统计 {
	static int[][] s=new int[100001][100001];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),d=sc.nextInt(),k=sc.nextInt();
		int ts,id;
		for(int i=1;i<=n;i++) {
			ts=sc.nextInt();
			id=sc.nextInt();
			s[id][ts]+=k;
			s[id][ts+d]-=k;
		}
		for(int i=1;i<=100000;i++) {
			for(int j=1;j<=100000;j++) {
				s[i][j]+=s[i][j-1];
				if(s[i][j]>=k) {
					System.out.println(i);
				}
			}
		}
	}
}
