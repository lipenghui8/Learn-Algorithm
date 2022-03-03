package 算法练习;

import java.io.BufferedInputStream;
import java.util.Scanner;

class jiandangjisuanqi {
	public static void main(String[]args) {
		Scanner in=new Scanner(new BufferedInputStream(System.in));
		while(in.hasNext()) {
			int a=in.nextInt();
			int b=in.nextInt();
			if(a==0&&b==0)
				return;
			int res=1;
			for(int i=0;i<b;i++) {
				res=(res*a)%1000;
			}
			System.out.println(res);
		}
	}
}
