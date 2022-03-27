package t2021_1;

public class 直线 {
	public static void main(String[] args) {
		double[][] line=new double[10000000][2];
		int sum=0;
		for(int x1=0;x1<20;x1++) {
			for(int y1=0;y1<21;y1++) {
				for(int x2=0;x2<20;x2++) {
					for(int y2=0;y2<21;y2++) {
						if((x1==x2&&y1==y2)||(x1==x2)) {
							continue;
						}
						double k=(y2-y1)/1.0/(x2-x1);
						k=Math.round(k*10000)/10000.0;
						double b=y1-(y2-y1)/1.0/(x2-x1)*x1;
						b=Math.round(b*10000)/10000.0;
						int flag=0;
						for(int i=0;i<sum;i++) {
							if(line[i][0]==k&&line[i][1]==b) {
								flag=1;
							}
						}
						if(flag==0) {
							line[sum][0]=k;
							line[sum][1]=b;
							sum++;
						}
					}
				}
			}
		}
		System.out.println(sum+20);
	}
}
