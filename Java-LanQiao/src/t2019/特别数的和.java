package t2019;

import java.util.Scanner;

public class 特别数的和 {
	static int n,sum=0;
	static boolean check(int n) {
		if(n==2||n==0||n==1||n==9) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			if(i/10==0) {
				if(check(i)) {
					sum+=i;
				}
			}else if(i/100==0) {
				if(check(i%10)||check(i/10)) {
					sum+=i;
				}
			}else if(i/1000==0) {
				if(check(i%10)||check(i/10%10)||check(i/100%10)) {
					sum+=i;
				}
			}else if(i/10000==0) {
				if(check(i%10)||check(i/10%10)||check(i/100%10)||check(i/1000%10)) {
					sum+=i;
				}
			}else if(i/100000==0){
				if(check(i%10)||check(i/10%10)||check(i/100%10)||check(i/1000%10)||check(i/10000%10)) {
					sum+=i;
				}
			}
		}
		System.out.println(sum);
	}
}
