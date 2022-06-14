package t2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 巧克力 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt(),n=sc.nextInt();
		int[][] s=new int[3][n+1];
		long cnt=0;
		for(int i=1;i<=n;i++) {
			s[0][i]=sc.nextInt();
			s[1][i]=sc.nextInt();
			s[2][i]=sc.nextInt();
		}
		Arrays.sort(s,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]<o1[0]) {
					return -1;
				}else {
					return 1;
				}
			}
		});
//		for(int i=1;i<=n;i++) {
//			System.out.println(s[0][i]+"--"+s[1][i]+"--"+s[2][i]);
//		}
		for(int d=1;d<=x;d++){
			int flag=0;
			for(int i=1;i<=n;i++) {
				if(s[1][i]>=d&&s[2][i]>0) {
					cnt+=s[0][i];
					s[2][i]--;
					flag=1;
					break;
				}
			}
			if(flag==0) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(cnt);
	}
}
