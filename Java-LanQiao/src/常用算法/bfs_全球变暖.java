package 常用算法;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs_全球变暖 {
	static int n;
	static char[][] aa=new char[1020][1020];
	static int[][] v=new int[1020][1020];
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,-1,1};
	static int sum=0;
	static void bfs(int a,int b) {//当前岛屿是否被淹没
		v[a][b]=1;
		Queue<node> queue=new LinkedList<>();
		queue.add(new node(a,b));
		int cnt=0;
		while(!queue.isEmpty()) {
			node tNode=queue.peek();
			queue.remove();
			int xx=tNode.x;
			int yy=tNode.y;
			cnt++;
			Boolean ju=false;
			for(int i=0;i<4;i++) {
				int x=xx+dx[i];
				int y=yy+dy[i];
				if(v[x][y]==1||x<1||x>n||y<1||y>n) {
					continue;
				}
				if(aa[x][y]=='#') {
					queue.add(new node(x, y));
					v[x][y]=1;
				}else {
					ju=true;
				}
			}
			if(ju) {
				cnt--;
			}
		}
		if(cnt==0) {
			sum++;
		}
	}
	
	public static void main(String[] args) {
		//输入岛屿情况
		Scanner sc=new Scanner(System.in);
		n=Integer.parseInt(sc.nextLine().toString());
		for(int i=1;i<=n;i++) {
			String aaString=sc.nextLine();
			for(int j=1;j<=n;j++) {
				aa[i][j]=aaString.charAt(j-1);
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(aa[i][j]=='#'&&v[i][j]==0) {
					bfs(i,j);
				}
			}
		}
		System.out.println(sum);
	}
}
