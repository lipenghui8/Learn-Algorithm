package lanqiao;

import java.util.Scanner;

public class t9 {
	static int[][] s=new int[1005][4];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt(),v=sc.nextInt();
		int t=0,sumx;
		for(int i=1;i<=m;i++) {
			s[i][1]=sc.nextInt();
			s[i][2]=sc.nextInt();
			s[i][3]=sc.nextInt();
		}
		t+=(s[2][1]-s[1][1])*v;
		System.out.println(t);
		for(int i=3;i<=m;i++) {
			if(t%(s[i][2]+s[i][3])<s[i][2]) {
				
			}else if(t%(s[i][2]+s[i][3])>=s[i][2]) {
				t+=s[i][3];
			}
			t+=(s[i][1]-s[i-1][1])*v;
			System.out.println(t+"----");
		}
		System.out.println(t+(n-s[m][1])*v);
	}
}
