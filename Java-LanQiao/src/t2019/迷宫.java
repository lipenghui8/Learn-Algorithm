
package t2019;

public class 迷宫 {
	static int[][] visit=new int[31][51];
	static int min=Integer.MAX_VALUE;
	static char[] ans= {'D','U','L','R'};
	static void dfs(int x,int sum) {
		if(x>30) {
			if(sum<min) {
				min=sum;
				
			}
			for(int i=1;i<=sum;i++) {
				
			}
			return;
		}
		for(int i=1;i<=50;i++) {
			if(visit[x][i]==0) {
				visit[x][i]=1;
				
			}
		}
	}
	public static void main(String[] args) {
		dfs(1,0);
	}
}
