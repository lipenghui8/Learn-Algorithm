package t2021;

public class 最小权值 {
	public static void main(String[] args) {
		long[] f=new long[2022];
		for(int i=1;i<2022;i++) {
			f[i]=Long.MAX_VALUE;
		}
		for(int i=0;i<2022;i++) {
			for(int j=0;j<=i-1;j++) {
				f[i]=Math.min(1+2*f[j]+3*f[i-j-1]+j*j*(i-j-1), f[i]);
			}
		}
		System.out.println(f[2021]);
	}
}
