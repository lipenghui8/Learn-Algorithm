package 重点二刷;

public class 分配口罩 {
	static int[] num={9090400, 8499400, 5926800, 8547000, 4958200,
			  4422600, 5751200, 4175600, 6309600, 5865200, 
			  6604400, 4635000, 10663400, 8087200, 4554000
		};
	static int[] v=new int[15];
	static int res=Integer.MAX_VALUE;
	static int sum=0;
	
	static void dfs(int n) {
		if(n>=sum/2) {
			if((n-sum/2)*2<res) {
				res=(n-sum/2)*2;
			}
			return;
		}
		for(int i=0;i<num.length;i++) {
			if(v[i]==0) {
				v[i]=1;
				dfs(n+num[i]);
				v[i]=0;
			}
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<num.length;i++) {
			sum+=num[i];
		}
		dfs(0);
		System.out.println(res);
	}
}
