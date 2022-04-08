package 二刷_t2018;

public class 方格计数 {
	public static void main(String[] args) {
		int sum=0;
		int d2=1000*1000;
		for(int i=1;i<=1000;i++) {
			for(int j=1;j<=1000;j++) {
				if(i*i+j*j<=d2) {
					sum++;
				}
			}
		}
		System.out.println(sum*4);
	}
}
