package 二刷_2021_1;

public class 路径 {
	static int[][] s=new int[2022][2022];
	static int gcd(int a,int b) {
		return b==0?a:gcd(b, a%b);
	}
	static int lcm(int a,int b) {
		return a*b/gcd(a, b);
	}
	public static void main(String[] args) {
		for(int i=1;i<=2021;i++) {
			for(int j=i+1;j<=i+21&&j<=2021;j++) {
				s[i][j]=s[j][i]=lcm(i, j);
			}
		}
		for(int k=1;k<=2021;k++) {
			for(int i=1;i<=2021;i++) {
				if(s[i][k]==0) {
					continue;
				}
				for(int j=1;j<=2021;j++) {
					if(s[k][j]==0) {
						continue;
					}
					if(s[i][j]>(s[i][k]+s[k][j])||s[i][j]==0) {
						s[i][j]=s[i][k]+s[k][j];
					}
				}
			}
		}
		System.out.println(s[1][2021]);
	}
}