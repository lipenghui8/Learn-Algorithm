package 常用算法;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class node{
	int x,y;
	node(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class BFS走迷宫 {
	static int[][] a=new int[500][500];//迷宫
	static int[][] v=new int[500][500];
	static int[][] ans=new int[500][500];
	static int n,m;
	static Queue<node> queue=new LinkedList<>();
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static void bfs() {
		queue.add(new node(1, 1));
		v[1][1]=1;
		while(!queue.isEmpty()) {
			node nn=queue.peek();
			queue.remove();
			int x=nn.x;
			int y=nn.y;

			for(int i=0;i<4;i++) {
				int xx=x+dx[i];
				int yy=y+dy[i];
				if(xx<1||xx>n||yy<1||yy>m||a[xx][yy]==1||v[xx][yy]==1) {
					continue;
				}
				queue.add(new node(xx, yy));
				v[xx][yy]=1;
				ans[xx][yy]=ans[x][y]+1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		bfs();
		System.out.println(ans[n][m]);
	}
}
