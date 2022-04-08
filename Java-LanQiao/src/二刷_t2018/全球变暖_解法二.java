package 二刷_t2018;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 全球变暖_解法二 {
	static Queue<node> q=new LinkedList<>();
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int cnt=0,n;
	static char[][] s=new char[1010][1010];
	static int[][] v=new int[1010][1010];
	
	static void bfs(int px,int py) {
		int suma=0,sumb=0;
		node start=new node(px, py);
		v[px][py]=1;
		q.add(start);
		while(!q.isEmpty()) {
			node sNode=q.peek();
			q.remove();
			int xx=sNode.x;
			int yy=sNode.y;
			suma++;
			for(int i=0;i<4;i++) {
				int x=xx+dx[i];
				int y=yy+dy[i];
				if(x>=1&&x<=n&&y>=1&&y<=n&&s[x][y]=='.') {
					sumb++;
					break;
				}
			}
			for(int i=0;i<4;i++) {
				int x=xx+dx[i];
				int y=yy+dy[i];
				if(x>=1&&x<=n&&y>=1&&y<=n&&v[x][y]==0&&s[x][y]=='#') {
					v[x][y]=1;
					q.add(new node(x, y));
				}
			}
		}
		if(suma==sumb) {
			cnt++;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=Integer.parseInt(sc.nextLine());
		for(int i=1;i<=n;i++) {
			String ssString=sc.nextLine();
			char[] ss=ssString.toCharArray();
			for(int j=1;j<=n;j++) {
				s[i][j]=ss[j-1];
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(s[i][j]=='#'&&v[i][j]==0) {
					bfs(i,j);
				}
			}
		}
		System.out.println(cnt);
	}
}
