package 常用算法;

import java.util.Arrays;

public class duhe_tanxin {
	//贪心求最小渡河时间,下标从1开始
	private static int f(int[]a) {//a为升序排列的渡河时间数组
		int ans=0,left=a.length-1;
		while(left>0) {
			if(left==1) {
				ans+=a[1];
				break;
			}
			else if(left==2) {
				ans+=a[2];
				break;
			}
			else if(left==3) {
				ans+=a[1]+a[2]+a[3];
				break;
			}
			else {
				//1,2出发，1返回，最后两名出发，2返回
				int s1=a[2]+a[1]+a[left]+a[2];
				//1和最后一名出发，1返回，1和倒数第二出发，1返回
				int s2=a[left]+a[1]+a[left-1]+a[1];
				ans+=Math.min(s1, s2);
				left-=2;//河岸减少两人
			}
		}
		return ans;
	}
	public static void main(String[] args) {
//		int[]a= {0,6,3,7,3,5,3,6,8,3,1,9};
		int[]a= {0,1,2,5,10};
		Arrays.sort(a);
		System.out.println(f(a));
	}
}
