package t2020_2;

public class 寻找2020 {
	public static void main(String[] args) {
		long[][] s=new long[3000][3000];
		s[1][1]=1;
		int x=1,y=1,p=x,q=y,flag=0;
		for(int i=1;i<=800;i++) {
			//右上
			if(x-1>=1&&flag==0) {
				p=x-1;
				q=y+1;
			}else if(x-1==0&&flag==0){//右
				p=x;
				q=y+1;
				flag=1;
			}else if(flag==1&&y-1>=1){//左下
				p=x+1;
				q=y-1;
			}else if(flag==1&&y-1==0) {//下
				p=x+1;
				q=y;
				flag=0;
			}
			s[p][q]=s[x][y]+1;
			x=p;
			y=q;
		}
//		for(int i=1;i<=20;i++) {
//			for(int j=1;j<=20;j++) {
//				System.out.printf("%4d",s[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(s[20][20]);
	}
}
