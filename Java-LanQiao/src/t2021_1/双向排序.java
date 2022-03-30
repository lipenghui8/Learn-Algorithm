package t2021_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class 双向排序 {
	static Integer[] s=new Integer[100000];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		for(int i=1;i<=n;i++) {
			s[i]=i;
		}
		int p,q;
		Comparator<Integer> cmp=new myCmp();
		for(int i=1;i<=m;i++) {
			p=sc.nextInt();
			q=sc.nextInt();
			if(p==0) {
				Arrays.sort(s,1,q+1,cmp);
			}else if(p==1) {
				Arrays.sort(s, q, n+1);
			}
		}
		for(int i=1;i<=n;i++) {
			System.out.print(s[i]+" ");
		}
	}
}

class myCmp implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2-o1;
	}
	
}
