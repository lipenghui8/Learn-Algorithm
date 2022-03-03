package 算法练习;

import java.util.Scanner;

class feibonaqi {
	public static void main(String[] args) {
		int []f=new int[1000001];
		int n;
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		f[0]=7%3;
		f[1]=11%3;
		while(in.hasNextInt()) {
			n=in.nextInt();
			for(int i=2;i<=n;i++)
			{
				f[i]=(f[i-1]+f[i-2])%3;
			}
			if(f[n]%3==0)
				System.out.println("yes");
			else
				System.out.println("no");
		}
		in.close();
	}
}
