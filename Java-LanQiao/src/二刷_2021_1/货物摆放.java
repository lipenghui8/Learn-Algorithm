package 二刷_2021_1;

public class 货物摆放 {
	static long n=2021041820210418L,cnt=0;
	public static void main(String[] args) {
		for(long i=1;i<=1000000;i++) {
			if(n%i!=0) {
				continue;
			}
			for(long j=i;j<=Math.sqrt(n);j++) {
				if(n/i%j!=0) {
					continue;
				}
				long k=n/i/j;
				if(k<j) {
					continue;
				}
				if(i==j&&j==k) {
					cnt+=1;
				}else if(i!=j&&i!=k&&j!=k){
					cnt+=6;
				}else {
					cnt+=3;
				}
			}
		}
		System.out.println(cnt);
	}
}
