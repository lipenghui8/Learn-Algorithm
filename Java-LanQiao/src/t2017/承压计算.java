package t2017;

import java.util.Scanner;

public class 承压计算 {
	static double[][] s=new double[31][31];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=1;i<=29;i++) {
			for(int j=1;j<=i;j++) {
				s[i][j]=sc.nextDouble();
				s[i][j]+=(s[i-1][j]/2.0+s[i-1][j-1]/2.0);
			}
		}
		for(int j=1;j<=30;j++){
			s[30][j]+=(s[30-1][j]/2.0+s[30-1][j-1]/2.0);
		}
		double min=Double.MAX_VALUE;
		double max=Double.MIN_VALUE;
		for(int i=1;i<=30;i++) {
			if(s[30][i]<min) {
				min=s[30][i];
			}
			if(s[30][i]>max) {
				max=s[30][i];
			}
			System.out.print(s[30][i]+"    ");
		}
		System.out.println();
		System.out.println(max);
		System.out.println(min);
		long s=(long) (max/min*2086458231);
		System.out.println(s);
	}
}
