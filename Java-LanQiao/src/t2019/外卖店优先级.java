package t2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 外卖店优先级 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int t=sc.nextInt();
		HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
		for(int i=1;i<=m;i++){
			int ts=sc.nextInt();
			int id=sc.nextInt();
			if(map.containsKey(id)) {
				map.get(id).add(ts);
			}else {
				ArrayList<Integer> newlist=new ArrayList<>();
				newlist.add(ts);
				map.put(id, newlist);
			}
		}
		int res=0;
		for(int in:map.keySet()) {
			int[] count=new int[t+1];
			ArrayList<Integer> eArrayList=map.get(in);
			for(int i=0;i<eArrayList.size();i++) {
				int a=eArrayList.get(i);
				count[a]++;
			}
			int lv=0;
			boolean flag=false;
			for(int i=0;i<=t;i++) {
				if(count[i]==0) {
					if(lv!=0) {
						lv--;
					}
					if(lv<=3) {
						flag=false;
					}
				}else {
					lv+=2*count[i];
					if(lv>5) {
						flag=true;
					}
					
				}
			}
			if(flag) {
				res++;
			}
		}
		System.out.println(res);
	}
}
