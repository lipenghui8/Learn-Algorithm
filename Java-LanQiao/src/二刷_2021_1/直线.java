package 二刷_2021_1;

import java.util.HashSet;
import java.util.Set;
class ll{
	double a,b;
	ll(double a,double b){
		this.a=a;
		this.b=b;
	}
}
public class 直线 {
	static double[][] line=new double[1000000][2];
	public static void main(String[] args) {
		int sum=0;
		for(int x1=0;x1<20;x1++) {
			for(int y1=0;y1<21;y1++) {
				for(int x2=0;x2<20;x2++) {
					for(int y2=0;y2<21;y2++) {
						if(x1==x2&&y1==y2) {
							continue;
						}
						if(x1==x2) {
							continue;
						}
						double a=(y1-y2)*1.0/(x1-x2);
						double b=-(y1-y2)*1.0/(x1-x2)*x2+y2;
						a=Math.round(a*10000)/10000.0;
						b=Math.round(b*10000)/10000.0;
						System.out.println(a+"     "+b);
						int flag=0;
						for(int i=0;i<sum;i++) {
							if(line[i][0]==a&&line[i][1]==b) {
								flag=1;
							}
						}
						if(flag==0) {
							line[sum][0]=a;
							line[sum][1]=b;
							sum++;
						}
					}
				}
			}
		}
		System.out.println(20+sum);
	}
}
