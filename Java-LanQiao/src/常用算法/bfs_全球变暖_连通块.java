package 常用算法;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs_全球变暖_连通块 {
	static char[][] a=new char[1010][1010];
	static int[][] v=new int[1010][1010];
	static Queue<node> queue=new LinkedList<>();
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int n,sum=0;
	static void bfs() {
		while(!queue.isEmpty()) {
			node q=queue.peek();
			queue.remove();
			int xx=q.x;
			int yy=q.y;
			for(int i=0;i<4;i++) {
				int x=xx+dx[i];
				int y=yy+dy[i];
				if(a[x][y]=='.'||v[x][y]==1||x<1||x>n||y<1||y>n) {
					continue;
				}
				queue.add(new node(x, y));
				v[x][y]=1;
				a[x][y]='.';
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextLine().toString().charAt(0)-'0';
		for(int i=1;i<=n;i++) {
			String aaString=sc.nextLine();
			for(int j=1;j<=n;j++) {
				a[i][j]=aaString.charAt(j-1);
			}
		}
		char[][] b=new char[1010][1010];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				b[i][j]=a[i][j];
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(a[i][j]=='#') {
					if(b[i+1][j]=='.'||b[i][j+1]=='.'||b[i-1][j]=='.'||b[i][j-1]=='.') {
						a[i][j]='.';
					}
				}
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(a[i][j]=='#') {
					sum++;
					queue.add(new node(i, j));
					v[i][j]=1;
					a[i][j]='.';
					bfs();
				}
			}
		}
		System.out.println(sum);
	}
}
