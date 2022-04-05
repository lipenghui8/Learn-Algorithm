package 二刷_2020_2;

public class 七段码 {
	static int[] fa=new int[10];
	static int[][] e=new int[10][10];
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
			return fa[i];
		}
	}
	static void union(int i,int j) {
		int x=find(i);
		int y=find(j);
		fa[x]=y;
	}
	static int[] map=new int[7];
	public static void main(String[] args) {
		int ans=0;
		init();
		for(int i=1;i<=7;i++) {
			fa[i]=i;
		}
		for(int i=1;i<=127;i++) {
			int temp=i;
			for(int j=0;j<7;j++) {
				map[j]=temp%2;
				temp=temp/2;
			}
		}
	}
}
