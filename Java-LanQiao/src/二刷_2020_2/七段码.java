package 二刷_2020_2;

public class 七段码 {
	static int[] fa=new int[10];
	static int[][] e=new int[10][10];
	static int[] use=new int[10];
	static int ans=0;
	static void init(){
		e[1][2] = e[1][6] = 1;
		e[2][1] = e[2][7] = e[2][3] = 1;
		e[3][2] = e[3][4] = e[3][7] = 1;
		e[4][3] = e[4][5] = 1;
		e[5][4] = e[5][6] = e[5][7] = 1;
		e[6][1] = e[6][5] = e[6][7] = 1;
		e[7][2] = e[7][3] = e[7][5] = e[7][6] = 1;
	}
	static int find(int i) {
		if(fa[i]==i) {
			return i;
		}else {
			return find(fa[i]);
		}
	}
	static void union(int i,int j) {
		int x=find(i);
		int y=find(j);
		fa[x]=y;
	}
	static void dfs(int x) {
		if(x>7) {
			for(int i=1;i<=7;i++) {//对每个节点初始化父节点
				fa[i]=i;
			}
			for(int i=1;i<=7;i++) {
				for(int j=1;j<=7;j++) {
					if(e[i][j]==1&&use[i]==1&&use[j]==1) {
						union(i, j);
					}
				}
			}
			int k=0;
			for(int i=1;i<=7;i++) {
				if(use[i]==1&&find(i)==i) {
					k++;
				}
			}
			if(k==1) {
				ans++;
			}
			return;
		}
		use[x]=1;
		dfs(x+1);
		use[x]=0;
		dfs(x+1);
	}
	public static void main(String[] args) {
		init();
		dfs(1);
		System.out.println(ans);
	}
}
