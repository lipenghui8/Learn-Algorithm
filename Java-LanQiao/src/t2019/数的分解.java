package t2019;

public class 数的分解 {
	public static void main(String[] args) {
		int sum=0;
		for(int i=1;i<2019;i++) {
			for(int j=i+1;j<2019;j++) {
				for(int k=j+1;k<2019;k++) {
					if(i%10==2||i%10==4||i/10%10==2||i/10%10==4||i/100%10==2||i/100%10==4||i/1000%10==2||i/1000%10==4) {
						continue;
					}
					if(j%10==2||j%10==4||j/10%10==2||j/10%10==4||j/100%10==2||j/100%10==4||j/1000%10==2||j/1000%10==4) {
						continue;
					}
					if(k%10==2||k%10==4||k/10%10==2||k/10%10==4||k/100%10==2||k/100%10==4||k/1000%10==2||k/1000%10==4) {
						continue;
					}
					if(i+j+k==2019) {
						sum++;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
