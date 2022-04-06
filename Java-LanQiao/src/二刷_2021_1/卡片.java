package 二刷_2021_1;

public class 卡片 {
	static int[] cnt=new int[10];
	public static void main(String[] args) {
		int flag=0;
		for(int i=1;i<=Integer.MAX_VALUE;i++) {
			int t=i;
			while(t!=0) {
				cnt[t%10]++;
				if(cnt[t%10]>2021) {
					flag=1;
				}
				t=t/10;
			}
			if(flag==1) {
				System.out.println(i-1);
				break;
			}
		}
	}
}
