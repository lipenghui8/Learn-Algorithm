package t2020;

public class 扩散 {
	public static void main(String[] args) {
		int[][] s=new int[10000][10000];
		int[][] t=new int[10000][10000];
		int cnt=4;
		s[0+4000][0+4000]=s[2020+4000][11+4000]=s[11+4000][14+4000]=s[2000+4000][2000+4000]=1;
		t[0+4000][0+4000]=t[2020+4000][11+4000]=t[11+4000][14+4000]=t[2000+4000][2000+4000]=1;
		for(int i=1;i<=2020;i++) {
			for(int j=0;j<=9999;j++) {
				for(int k=0;k<=9999;k++) {
					if(s[j][k]==1&&t[j][k]==i) {
						if(j>0&&s[j-1][k]==0) {
							s[j-1][k]=1;
							t[j-1][k]=i+1;
							cnt++;
						}
						if(s[j+1][k]==0) {
							s[j+1][k]=1;
							t[j+1][k]=i+1;
							cnt++;
						}
						if(k>0&&s[j][k-1]==0) {
							s[j][k-1]=1;
							t[j][k-1]=i+1;
							cnt++;
						}
						if(s[j][k+1]==0) {
							s[j][k+1]=1;
							t[j][k+1]=i+1;
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
//		long sum=0;
//		for(int i=0;i<=4041;i++) {
//			for(int j=0;j<=4041;j++) {
//				if(s[i][j]==1) {
//					sum++;
//				}
//			}
//		}
//		System.out.println(sum);
	}
}
