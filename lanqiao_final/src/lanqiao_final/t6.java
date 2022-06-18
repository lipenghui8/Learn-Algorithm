package lanqiao_final;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class step{
	int x,y;
	int s=0;
	int len;
	int x1,y1;
	public step(int x,int y,int len) {
		this.x=x;
		this.y=y;
		this.len=len;
	}
}
public class t6 {
	static Queue<step> queue=new LinkedList<>();
	static int n,m;
	static step[][] s=new step[2000+1][2000+1];
	static int[][] v=new int[2000+1][2000+1];
	static int[]dx= {-1,1,0,0};
	static int[]dy= {0,0,-1,1};
	
	static void bfs(int p,int q,int len) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				v[i][j]=0;
				s[i][j]=new step(i, j, 0);
			}
		}
		queue.add(new step(p,q,len));
		v[1][1]=1;
		while(!queue.isEmpty()) {
			if(v[n][n]==1) {
				return;
			}
			step nStep=queue.remove();
			int xx=nStep.x;
			int yy=nStep.y;
			int sta=nStep.s;
			if(sta==1) {
				s[nStep.x1][nStep.y1].len=len+1;
				queue.add(new step(nStep.x1, nStep.y1,len+1));
			}
			for(int i=0;i<4;i++) {
				int x=xx+dx[i];
				int y=yy+dy[i];
				if(x>=1&&x<=n&&y>=1&&y<=n&&v[x][y]==0) {
					v[x][y]=1;
					s[x][y].len=len+1;
					queue.add(new step(x, y,len+1));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				s[i][j]=new step(i, j, 0);
			}
		}
		for(int i=1;i<=m;i++) {
			int x1=sc.nextInt(),y1=sc.nextInt(),x2=sc.nextInt(),y2=sc.nextInt();
			s[x1][y1].s=1;
			s[x1][y1].x1=x2;
			s[x1][y1].x1=x2;
			s[x2][y2].s=1;
			s[x2][y2].x1=x1;
			s[x2][y2].x1=x1;
		}
		int sum=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j&&j==n) {
					continue;
				}
				bfs(i, j, 0);
				sum+=s[n][n].len;
			}
		}
		double res=sum*1.0/(n*n);
		System.out.println(Math.round(10.2345/1000)*1000);
	}
}
