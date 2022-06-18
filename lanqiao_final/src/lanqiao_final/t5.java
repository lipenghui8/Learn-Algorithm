package lanqiao_final;

import java.util.Scanner;

public class t5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int[] s=new int[n+1];
		for(int i=1;i<=m;i++) {
			int k=sc.nextInt();
			int[] left=new int[k+1];
			for(int j=1;j<=k;j++) {
				left[j]=sc.nextInt();
			}
			int[] right=new int[k+1];
			for(int j=1;j<=k;j++) {
				right[j]=sc.nextInt();
			}
			char p=sc.next().toCharArray()[0];
			if(p=='>') {
				for(int j=1;j<=k;j++) {
					s[right[j]]=1;
				}
			}else if(p=='<') {
				for(int j=1;j<=k;j++) {
					s[left[j]]=1;
				}
			}else if(p=='=') {
				for(int j=1;j<=k;j++) {
					s[left[j]]=0;
					s[right[j]]=0;
				}
			}
		}
		int cnt=0;
		for(int i=1;i<=n;i++) {
			if(s[i]==1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
