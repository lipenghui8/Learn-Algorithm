package 二刷_2020_1;

public class 分配口罩 {
	static int[] num={9090400, 8499400, 5926800, 8547000, 4958200,
				  4422600, 5751200, 4175600, 6309600, 5865200, 
				  6604400, 4635000, 10663400, 8087200, 4554000
			}; 
	static int[] v=new int[15];
	static int[] ans=new int[16];
	static int min=Integer.MAX_VALUE,avg=0;
	static void dfs(int x,int sum) {
		if(sum>=avg) {
			min=Math.min(min, sum);
			return;
		}
		for(int i=0;i<num.length;i++) {
			if(v[i]==0) {
				v[i]=1;
				dfs(x+1, sum+num[i]);
				v[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<num.length;i++) {
			avg+=num[i];
		}
		avg=avg/2;
		dfs(1,0);
		System.out.println((min-avg)*2);
	}
}
