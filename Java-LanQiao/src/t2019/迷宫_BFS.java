package t2019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;

class node{
	int x,y;
	String road;
	node(int x,int y,String road){
		this.x=x;
		this.y=y;
		this.road=road;
	}
}
public class 迷宫_BFS {
	static int[][] s=new int[100][100];
	static int[][] v=new int[100][100];
	static int[][] ans=new int[100][100];
	static int[] bian= {};
	static int[] dx= {1,0,0,-1};
	static int[] dy= {0,-1,1,0};
	static char[] fan= {'D','L','R','U'};
	static int m=30,n=50;
	static Queue<node> queue=new LinkedList<>();
	
	static void bfs() {
		queue.add(new node(1, 1,""));
		v[1][1]=1;
		while(!queue.isEmpty()) {
			node r=queue.peek();
			queue.remove();
			int xx=r.x;
			int yy=r.y;
			String roadString=r.road;
			if(xx==m&&yy==n) {
				System.out.println(roadString);
			}
			for(int i=0;i<4;i++) {
				int x=xx+dx[i];
				int y=yy+dy[i];
				if(s[x][y]==1||v[x][y]==1||x<1||x>m||y<1||y>n) {
					continue;
				}
				queue.add(new node(x, y,roadString+fan[i]));
				v[x][y]=1;
				ans[x][y]=ans[xx][yy]+1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		for(int i=1;i<=30;i++) {
			String ssString=scanner.nextLine();
			for(int j=1;j<=50;j++) {
				s[i][j]=(ssString.charAt(j-1)-'0');
			}
		}
		bfs();
	}
}
