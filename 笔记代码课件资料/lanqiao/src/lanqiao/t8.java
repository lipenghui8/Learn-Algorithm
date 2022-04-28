package lanqiao;

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
public class t8 {
	static int[][] s=new int[205][205];
	static char[] step=new char[200];
	static char[][] res=new char[205][205];
	static int nn,nm;
	static int n;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=Integer.parseInt(sc.nextLine());
		String ss=sc.nextLine();
		step=ss.toCharArray();
		int x=100,y=100;
		int maxx=0,maxy=0;
		int minx=1000,miny=1000;
		for(int i=0;i<n;i++) {
			if(step[i]=='U') {
				x=x-1;
			}else if(step[i]=='D') {
				x=x+1;
			}else if(step[i]=='L') {
				y=y-1;
			}else if(step[i]=='R') {
				y=y+1;
			}
			if(x>maxx) {
				maxx=x;
			}
			if(x<minx) {
				minx=x;
			}
			if(y>maxy) {
				maxy=y;
			}
			if(y<miny) {
				miny=y;
			}
			s[x][y]=1;
		}
		nn=maxx+1-(minx-1)+1;
		nm=maxy+1-(miny-1)+1;
		for(int i=minx-1,p=1;i<=maxx+1&&p<=nn;i++,p++) {
			for(int j=miny-1,q=1;j<=maxy+1&&q<=nm;j++,q++) {
				if(s[i][j]==0) {
					res[p][q]='*';
				}else {
					res[p][q]=' ';
				}
				
			}
		}
		
		int[][] v=new int[200][200];
		Queue<node> queue=new LinkedList<>();
		node start=new node(1, 1);
		v[1][1]=1;
		queue.add(start);
		int[] dx= {1,-1,0,0};
		int[] dy= {0,0,-1,1};
		while(!queue.isEmpty()) {
			node sNode=queue.peek();
			queue.remove();
			int xx=sNode.x;
			int yy=sNode.y;
			
			int flag=0;
			for(int i=0;i<4;i++) {
				int nx=xx+dx[i];
				int ny=yy+dy[i];
				if(res[nx][ny]==' ') {
					flag=1;
				}
			}
			if(flag==0) {
				res[xx][yy]='#';
			}
			
			for(int i=0;i<4;i++) {
				int nx=xx+dx[i];
				int ny=yy+dy[i];
				if(nx>=1&&nx<=nn&&ny>=1&&ny<=nm&&res[nx][ny]=='*'&&v[nx][ny]==0) {
					v[nx][ny]=1;
					queue.add(new node(nx, ny));
				}
			}
		}
		for(int i=1;i<=nn;i++) {
			for(int j=1;j<=nm;j++) {
				if(res[i][j]=='#') {
					System.out.print(' ');
				}else {
					System.out.print(res[i][j]);
				}
			}
			System.out.println();
		}
	}
}
