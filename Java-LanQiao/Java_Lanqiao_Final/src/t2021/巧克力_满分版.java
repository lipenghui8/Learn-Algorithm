package t2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 巧克力_满分版 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt(),n=sc.nextInt();
		int[][] s=new int[4][n+1];
		long cnt=0;
		int[] rec=new int[n+1]; 
		for(int i=1;i<=n;i++) {
			s[0][i]=sc.nextInt();
			s[1][i]=sc.nextInt();
			s[2][i]=sc.nextInt();
			s[3][i]=i;
		}
		Arrays.sort(s,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]<o2[1]) {
					return 1;
				}else {
					return -1;
				}
			}
		});
		Queue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]<=o2[0]) {
					return -1;
				}else {
					return 1;
				}
			}
		});
		int j=1;
		for(int i=x;i>=1;i--) {
			while(s[j][1]>=i&&s[j][2]>0&&j<=n) {
				q.add(s[j]);
			}
			if(q.size()==0) {
				System.out.println(-1);
				return;
			}
			int[] k=q.peek();
			rec[k[3]]++;
			cnt+=k[0];
			if(rec[k[3]]==k[3]) {
				q.remove();
			}
		}
		System.out.println(cnt);
	}
}
