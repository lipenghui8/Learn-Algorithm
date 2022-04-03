package t2017;

public class 纸牌三角形 {
	static int[] a=new int[20];
	static int[] v=new int[20];
	static int sum=0;
	static void dfs(int x) {
		if(x>9) {
			if((a[1]+a[2]+a[3]+a[4])==(a[4]+a[5]+a[6]+a[7])&&(a[4]+a[5]+a[6]+a[7])==(a[1]+a[7]+a[8]+a[9])) {
				sum+=1;
				
			}
			return;
		}
		for(int i=1;i<=9;i++) {
			if(v[i]==0) {
				v[i]=1;
				a[x]=i;
				dfs(x+1);
				v[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		dfs(1);
		System.out.println(sum/6);
	}
}
