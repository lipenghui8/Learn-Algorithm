package 二刷_t2018;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 日志统计_暴力解法 {
	static Map<Integer, int[]> a=new HashMap<>();
	static int[] cid=new int[100001];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),d=sc.nextInt(),k=sc.nextInt();
		Integer ts,id;
		int p=0;
		for(int i=1;i<=n;i++) {
			ts=sc.nextInt();
			id=sc.nextInt();
			if(!a.containsKey(id)) {
				a.put(id, new int[100001]);
				cid[p++]=id;
			}
			a.get(id)[ts]++;
			a.get(id)[ts+d]--;
		}
		int[] res=new int[100000];
		int r=0;
		for(int i=0;i<p;i++) {
			int[] q=a.get(cid[i]);
			for(int j=1;j<q.length;j++) {
				q[j]+=q[j-1];
				if(q[j]>=k) {
					res[r++]=cid[i];
					break;
				}
			}
		}
		Arrays.sort(res,0,r);
		for(int i=0;i<r;i++) {
			System.out.println(res[i]);
		}
	}
}
