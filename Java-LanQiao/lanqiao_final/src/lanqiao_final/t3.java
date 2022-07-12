package lanqiao_final;

import java.util.Scanner;

public class t3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[]s=new int[n+1];
		for(int i=1;i<=n;i++) {
			s[i]=i;
		}
		for(int i=1;i<=m;i++) {
			char p=sc.next().toCharArray()[0];
			int x=sc.nextInt();
			if(p=='L') {
				int k=s[1];
				if(s[1]==x) {
					break;
				}
				int index=n;
				for(int j=2;j<=n;j++) {
					if(j>index) {
						break;
					}
					if(s[j]==x) {
						index=j;
					}
					int q=s[j];
					s[j]=k;
					k=q;
					
				}
				s[1]=x;
			}else if(p=='R') {
				int k=s[n];
				if(s[n]==x) {
					break;
				}
				int index=1;
				for(int j=n-1;j>=1;j--) {
					if(j<index) {
						break;
					}
					if(s[j]==x) {
						index=j;
					}
					int q=s[j];
					s[j]=k;
					k=q;
					
				}
				s[n]=x;
			}
			for(int t=1;t<=n;t++) {
				System.out.print(s[t]);
			}
			System.out.println();
		}
	}
}
