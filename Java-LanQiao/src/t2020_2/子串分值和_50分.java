package t2020_2;

import java.util.Scanner;

public class 子串分值和_50分 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		long sum=0;
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {
				String ss=s.substring(i,j);
				for(int k=0;k<26;k++) {
					if(ss.contains((char)('a'+k)+"")) {
						sum++;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
