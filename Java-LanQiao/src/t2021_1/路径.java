package t2021_1;

public class 路径 {
	static int s[][]=new int[2050][2050];
	static final int M=0x3f3f3f3f;
	static int gcd(int a,int b) {
		return b==0?a:gcd(b, a%b);
	}
	public static void main(String[] args) {
		for(int i=1;i<=2021;i++) {
			for(int j=1;j<=2021;j++) {
				s[i][j]=M;
			}
		}
		for(int i=1;i<=2021;i++) {
			for(int j=i+1;j<=2021&&j<=i+21;j++) {
				s[j][i]=s[i][j]=(i*j)/gcd(i, j);
			}
		}
		for(int k=1;k<=2021;k++) {
			for(int i=1;i<=2021;i++) {
				for(int j=1;j<=2021;j++) {
					if(i!=j&&i!=k&&j!=k) {
						if(s[i][j]>(s[i][k]+s[k][j])) {
							s[i][j]=(s[i][k]+s[k][j]);
						}
					}
				}
			}
		}
		System.out.println(s[1][2021]);
	}
}
