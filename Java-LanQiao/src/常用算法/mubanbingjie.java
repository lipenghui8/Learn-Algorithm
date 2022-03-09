package 常用算法;

import java.util.Arrays;
import java.util.Scanner;

public class mubanbingjie {
	static int M=30;
	static int n=0,sum=0,max=-1;
	static int[] s=new int[M];//木棍
	static int[] st=new int[M];//木棍是否用过
	static int len=0;//每根拼接木棍的长度
	static int cnt=0;//拼接成的长木棍数
	
	public static boolean dfs(int num,int lenn,int start) {
		//num为单前已经分到第几快，lenn表示当前木棍多长，start为从哪开始枚举
		if(num>cnt) {
			return true;
		}
		if(lenn==len) {
			return dfs(num+1,0,n);
		}
		int last=0;
		for(int i=start;i!=0;i--) {//从大到小开始枚举
			if(s[i]!=last&&st[i]==0&&lenn+s[i]<=len) {
				st[i]=1;
				lenn+=s[i];
				if(dfs(num,lenn,i-1)) {
					return true;
				}
				last=s[i];
				st[i]=0;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			n=sc.nextInt();
			if(n==0) {
				break;
			}
			sum=0;
			max=-1;
			for(int i=1;i<=n;i++) {
				s[i]=sc.nextInt();
				sum+=s[i];
				max=Math.max(max, s[i]);
			}
			Arrays.sort(s,1,n+1);
			for(int i=max;i<=sum;i++) {
				if(sum%i!=0)continue;
				len=i;
				cnt=sum/i;
				if(dfs(1,0,n)) {
					break;
				}
			}
			System.out.println(len);
		}
	}
}
