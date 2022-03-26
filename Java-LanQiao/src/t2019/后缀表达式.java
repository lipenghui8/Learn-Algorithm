package t2019;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class MyComprator implements Comparator<Integer>{

	@Override
	public int compare(Integer a, Integer b) {
		// TODO Auto-generated method stub
		if(Math.abs(a)>=Math.abs(b)) {
			return -1;
		}else {
			return 1;
		}
	}
	
}
public class 后缀表达式 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int max=Integer.MIN_VALUE;
		Integer[] s=new Integer[n+m+1];
		for(int i=0;i<n+m+1;i++) {
			s[i]=sc.nextInt();
			if(s[i]>max) {
				max=s[i];
			}
		}
		MyComprator cmp=new MyComprator();
		Arrays.sort(s,cmp);
		int flag=0;
		int sum=max,p=n,q=m;
//		for(int i=0;i<n+m+1;i++) {
//			System.out.print(s[i]+" ");
//		}
//		System.out.println();
		for(int i=0;i<n+m+1;i++) {
			if(s[i]==max&&flag==0) {
				flag=1;
				continue;
			}
			if(s[i]>0) {
				if(p>0) {
					sum+=s[i];
					p--;
				}else if(q>0){
					sum-=s[i];
					q--;
				}
			}else if(s[i]<0) {
				if(q>0) {
					sum-=s[i];
					q--;
				}else if(q>0){
					sum+=s[i];
					p--;
				}
			}
		}
		System.out.println(sum);
	}
}
