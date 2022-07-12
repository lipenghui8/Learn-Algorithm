package lanqiao_final;

public class t2 {
	static int f(int n) {
		int c=0;
		int j=2;
		while(n!=1) {
			if(n%j==0) 
			{
				while(n%j==0) {
					n=n/j;
					c++;
				}
			}else {
				j++;
				if(j>12) {
					return -1;
				}
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		int cnt=0;
		for(int i=2333333;i<=23333333;i++) {
			if(f(i)==12) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
