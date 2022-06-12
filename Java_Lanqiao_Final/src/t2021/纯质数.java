package t2021;

public class 纯质数 {
	static boolean isDig(int n) {
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int cnt=0;
		for(int i=2;i<=20210605;i++) {
			int j=i,flag=0;
			while(j>0) {
				int k=j%10;
				j=j/10;
				if(k==0||k==1||k==4||k==6||k==8||k==9) {
					flag=1;
				}
			}
			if(flag==1) {
				continue;
			}
			if(isDig(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
