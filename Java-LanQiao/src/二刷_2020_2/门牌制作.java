package 二刷_2020_2;

public class 门牌制作 {
	public static void main(String[] args) {
		int sum=0;
		for(int i=1;i<=2020;i++) {
			if(i%10==2) {
				sum++;
			}
			if(i/10%10==2) {
				sum++;
			}
			if(i/100%10==2) {
				sum++;
			}
			if(i/1000%10==2) {
				sum++;
			}
		}
		System.out.println(sum);
	}
}
