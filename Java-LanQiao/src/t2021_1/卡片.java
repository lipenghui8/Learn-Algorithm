package t2021_1;

public class 卡片 {
	public static void main(String[] args) {
		int[] s=new int[10];
		for(int i=1;i<=100000;i++) {
			int k=i;
			while(k!=0) {
				int p=k%10;
				s[p]++;
				if(s[p]>2021) {
					System.out.println(i-1);
					return;
				}
				k=k/10;
			}
		}
	}
}
