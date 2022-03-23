package 常用算法;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class point{
	int x;
	int y;
	int step;
}

public class bfs_迷宫 {
	static int[][] a=new int[100][100];//迷宫,1表空地，2表障碍
	static int[][] v=new int[100][100];
	static int m,n;//迷宫大小
	static int p,q;//终点坐标
	static int flag=0;//用来表示路径是否存在
	static Queue<point> queue=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		m=5;n=4;
		p=4;q=3;
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		
		//BFS
		point start=new point();
		start.x=1;
		start.y=1;
		start.step=0;
		queue.add(start);
		v[1][1]=1;
		
		while(!queue.isEmpty()) {
			int x=queue.peek().x;
			int y=queue.peek().y;
			if(x==p&&y==q) {
				flag=1;
				System.out.println(queue.peek().step);
				break;
			}
			//下
			if(a[x+1][y]==1&&v[x+1][y]==0) {
				v[x+1][y]=1;
				point r=new point();
				r.x=x+1;
				r.y=y;
				r.step=queue.peek().step+1;
				queue.add(r);
			}
			//左
			if(a[x][y-1]==1&&v[x][y-1]==0) {
				v[x][y-1]=1;
				point r=new point();
				r.x=x;
				r.y=y-1;
				r.step=queue.peek().step+1;
				queue.add(r);
			}
			//右
			if(a[x][y+1]==1&&v[x][y+1]==0) {
				v[x][y+1]=1;
				point r=new point();
				r.x=x;
				r.y=y+1;
				r.step=queue.peek().step+1;
				queue.add(r);
			}
			//上
			if(a[x-1][y]==1&&v[x-1][y]==0) {
				v[x-1][y]=1;
				point r=new point();
				r.x=x-1;
				r.y=y;
				r.step=queue.peek().step+1;
				queue.add(r);
			}
			queue.remove();//拓展完了将队首元素出队
		}
		if(flag==0) {
			System.out.println("没有路径");
		}
	}
}
