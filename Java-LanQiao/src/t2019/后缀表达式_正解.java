package t2019;

import java.util.Scanner;

public class 后缀表达式_正解 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int[] s=new int[m+n+1+10];
		long minz=Integer.MAX_VALUE,maxf=Integer.MIN_VALUE,sumn=0,sumabs=0,numz=0,numf=0;
		for(int i=1;i<=m+n+1;i++) {
			s[i]=sc.nextInt();
			sumn+=s[i];
			sumabs+=Math.abs(s[i]);
			if(s[i]>0) {
				minz=Math.min(minz, s[i]);
				numz++;
			}else{
				maxf=Math.max(maxf, s[i]);
				numf++;
			}
		}
		if(numf==m) {
			System.out.println(sumabs);
		}else if(numf>m) {
			if(numf==(n+m+1)) {
				System.out.println(sumabs+2*maxf);
			}else if(m==0) {
				System.out.println(sumn);
			}else {
				System.out.println(sumabs);
			}
		}else if(numf<m) {
			if(numf==0) {
				System.out.println(sumabs-2*minz);
			}else {
				System.out.println(sumabs);
			}
		}
	}
}
