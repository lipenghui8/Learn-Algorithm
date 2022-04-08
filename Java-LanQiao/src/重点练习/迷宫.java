package 重点练习;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node{
	int x,y;
	String path="";
	node(int x,int y,String path){
		this.x=x;
		this.y=y;
		this.path=path;
	}
}
public class 迷宫 {
	static int[][] s=new int[32][52];
	static int[][] v=new int[32][52];
	static int[] dx= {1,0,0,-1};
	static int[] dy= {0,-1,1,0};
	static char[] dd= {'D','L','R','U'};
	static Queue<node> queue=new LinkedList<>();
	static void bfs() {
		node n=new node(1, 1, "");
		queue.add(n);
		while(!queue.isEmpty()) {
			node qNode=queue.peek();
			queue.remove();
			int xx=qNode.x;
			int yy=qNode.y;
			String ss=qNode.path;
			if(xx==30&&yy==50) {
				System.out.println(ss);
				return;
			}
			for(int i=0;i<4;i++) {
				int x=xx+dx[i];
				int y=yy+dy[i];
				if(x>=1&&x<=30&&y>=1&&y<=50&&s[x][y]==0&&v[x][y]==0) {
					v[x][y]=1;
					String s=ss+dd[i];
					queue.add(new node(x, y, s));
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=1;i<=30;i++) {
			String sString=sc.nextLine();
			char[] ss=sString.toCharArray();
			for(int j=1;j<=50;j++) {
				s[i][j]=ss[j-1]-'0';
			}
		}
		bfs();
	}
}
