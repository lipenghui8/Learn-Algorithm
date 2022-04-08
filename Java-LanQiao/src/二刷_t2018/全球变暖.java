package 二刷_t2018;

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
public class 全球变暖 {
	static Queue<node> q=new LinkedList<>();
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int cnt=0,n;
	static int cnty=0;
	static char[][] s=new char[1010][1010];
	static int[][] v=new int[1010][1010];
	
	static boolean bfs(int px,int py) {
		int suma=0,sumb=0;
		node start=new node(px, py);
		q.add(start);
		while(!q.isEmpty()) {
			node sNode=q.peek();
			q.remove();
			int xx=sNode.x;
			int yy=sNode.y;
//			suma++;
//			for(int i=0;i<4;i++) {
//				if(s[xx+dx[i]][xx+dy[i]]=='.') {
//					sumb++;
//					break;
//				}
//			}
			int flag=0;
			for(int i=0;i<4;i++) {
				int x=xx+dx[i];
				int y=yy+dy[i];
				if(s[x][y]=='.') {
					flag=1;
				}
				if(x>=1&&x<=n&&y>=1&&y<=n&&v[x][y]==0&&s[x][y]=='#') {
					v[x][y]=1;
					q.add(new node(x, y));
				}
			}
			if(flag==0) {
				cnty++;
			}
		}
		if(suma==sumb) {
			return true;
		}else {
			return false;
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
					cnt++;
				}
			}
		}
		System.out.println(cnt-cnty);
	}
}
