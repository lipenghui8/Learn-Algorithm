package t2018;

import java.util.Scanner;

public class 螺旋折线 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long x=sc.nextLong(),y=sc.nextLong();
		long ay=Math.abs(y),ax=Math.abs(x);
		long sumup=0,sumle=0,sumri=0,sumdo=0;
		//上
		if((ay>ax&&y>0)||(y>0&&y==-x)) {
			//shang
			for(int i=1;i<y;i++) {
				sumup+=2*i;
			}
			sumri=sumup+2*y;
			for(int i=1;i<=y;i++) {
				sumle=sumle+i*2-1;
			}
			sumdo=sumle;
			sumup=sumup+Math.abs(y+x);
		}else if((ax>ay&&x>0)||(x>0&&x==y)){//you
			//you
			for(int i=1;i<x;i++) {
				sumri+=2*i;
			}
			sumup=sumri+x*2;
			for(int i=1;i<=y;i++) {
				sumdo=sumdo+i*2-1;
			}
			sumle=sumdo;
			sumri+=Math.abs(y-x);
		}else if((ax>ay&&x<0)||(x<0&&x==y)){//zuo
			//zuo
			int i=1;
			for(i=1;i<ax;i++) {
				sumle+=i*2-1;
			}
			//xia
			sumdo=sumle+i*2-1;
			//you
			for(i=1;i<ax;i++) {
				sumri+=i*2;
			}
			sumup=sumri;
			sumle+=Math.abs(y-x-1);
		}else if((ay>ax&&y<0)||(x==-y&&x>0)){//xia
			//xia
			for(int i=1;i<=ay;i++) {
				sumdo=sumdo+i*2-1;
			}
			sumle=sumdo;
			for(int i=1;i<=ay;i++) {
				sumri=sumri+i*2;
			}
			sumup=sumri;
			sumdo+=Math.abs(ay-x);
		}
		System.out.println(sumdo+sumle+sumri+sumup);
//		System.out.println(sumup);
//		System.out.println(sumdo);
//		System.out.println(sumle);
//		System.out.println(sumri);
	}
}
