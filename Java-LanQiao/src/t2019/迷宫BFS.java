package t2019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class point{
	int x,y,step;
}

public class 迷宫BFS {
	static int[][] a=new int[100][100];
	static int[][] v=new int[100][100];
	static int p=30,q=50;//迷宫终点
	static int flag=0;
	static Queue<point> Q=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String aa="";
		for(int i=1;i<=30;i++) {
			String as=sc.nextLine();
			aa+=as;
		}
		//接收数据
		char[] ab=aa.toCharArray();
		for(int i=1;i<=30;i++) {
			for(int j=1;j<=50;j++) {
				a[i][j]=ab[50*(i-1)+j-1];
			}
		}
		//初始化起点和起点的访问数组并加入队列
		point start=new point();
		start.x=1;
		start.y=1;
		start.step=0;
		v[1][1]=1;
		Q.add(start);
		
		//遍历队列
		while(!Q.isEmpty()) {
			//取出队首元素
			int x=Q.peek().x;
			int y=Q.peek().y;
			int step=Q.peek().step;
			
			if(x>30||x<1||y<1||y>50) {
				Q.remove();
				continue;
			}
			if(x==p&&y==q) {
				flag=1;
				System.out.println(Q.peek().step);
				break;
			}
			//下
			if(a[x+1][y]==0&&v[x+1][y]==0) {
				v[x+1][y]=1;
				point rPoint=new point();
				rPoint.x=x+1;
				rPoint.y=y;
				rPoint.step=step+1;
				Q.add(rPoint);
			}
			//左
			if(a[x][y-1]==0&&v[x][y-1]==0) {
				v[x][y-1]=1;
				point rPoint=new point();
				rPoint.x=x;
				rPoint.y=y-1;
				rPoint.step=step+1;
				Q.add(rPoint);
			}
			//右
			if(a[x][y+1]==0&&v[x][y+1]==0) {
				v[x][y+1]=1;
				point rPoint=new point();
				rPoint.x=x;
				rPoint.y=y+1;
				rPoint.step=step+1;
				Q.add(rPoint);
			}
			//上
			if(a[x-1][y]==0&&v[x-1][y]==0) {
				v[x-1][y]=1;
				point rPoint=new point();
				rPoint.x=x-1;
				rPoint.y=y;
				rPoint.step=step+1;
				Q.add(rPoint);
			}
			Q.remove();
		}
		if(flag==0) {
			System.out.println(0);
		}
	}
}
