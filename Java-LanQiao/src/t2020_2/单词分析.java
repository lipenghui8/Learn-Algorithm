package t2020_2;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;

public class 单词分析 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		char[] ss=s.toCharArray();
		Arrays.sort(ss);
		char ans = 0,ch;
		int sum=0,max=Integer.MIN_VALUE;
		for(int i=0;i<ss.length;i++) {
			ch=ss[i];
			sum=1;
			for(int j=i+1;j<ss.length;j++) {
				if(ss[j]==ch) {
					sum++;
					if(sum>max) {
						max=sum;
						ans=ch;
					}
				}else {
					i=i+sum-1;
					break;
				}
			}
		}
		System.out.println(ans);
		System.out.println(max);
	}
}
