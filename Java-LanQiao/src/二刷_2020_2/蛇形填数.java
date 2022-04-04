package 二刷_2020_2;

public class 蛇形填数 {
	public static void main(String[] args) {
		int flag=0;
		long[][] a=new long[10000][10000];
		a[1][1]=1L;
		int p=1,q=1;
		for(int i=1;i<=1000;i++) {
			if(flag==0&&p!=1) {//右上
				a[p-1][q+1]=a[p][q]+1;
				p=p-1;
				q=q+1;
			}else if(flag==0&&p==1) {//you
				a[p][q+1]=a[p][q]+1;
				flag=1;
				q=q+1;
			}else if(flag==1&&q!=1) {//zuoxia
				a[p+1][q-1]=a[p][q]+1;
				p=p+1;
				q=q-1;
			}else if(flag==1&&q==1) {//xia
				a[p+1][q]=a[p][q]+1;
				p=p+1;
				flag=0;
			}
		}
		for(int i=1;i<=20;i++) {
			for(int j=1;j<=20;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(a[20][20]);
	}
}
