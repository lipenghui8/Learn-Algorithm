
package t2018;

public class 方格计数 {
	public static void main(String[] args) {
		int sum=0;
		for(int i=-1000;i<=-1;i++) {
			for(int j=1000;j>=1;j--) {
				if(Math.sqrt(i*1.0*i+j*j)<=1000) {
					sum++;
				}
			}
		}
		System.out.println(sum*4);
	}
}
