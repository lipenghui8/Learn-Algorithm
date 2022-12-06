package t202104;

import java.util.Scanner;

public class t202104_1 {
	static int[] s=new int[256];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt(),l=sc.nextInt();
		int k=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				k=sc.nextInt();
				s[k]++;
			}
		}
		for(int i=0;i<l;i++) {
			System.out.print(s[i]+" ");
		}
	}
}
