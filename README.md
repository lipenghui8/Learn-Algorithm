## 1、0-1背包问题(dp)

<img src="https://gitee.com/lipenghuihenu/picgo-image/raw/master/image-20220307094557633.png" alt="image-20220307094557633" style="zoom: 50%;" />

``` java
public class beibao01 {
	public static void main(String[] args) {
		int [][]f=new int[5][9];//f表示最优解
		int []w= {0,2,3,4,5};//表示重量,一共有四件物品
		int []v= {0,3,4,5,8};//表示价值
		
		for(int i=1;i<5;i++) {//i表示物品，j表示背包容量
			for(int j=1;j<9;j++) {
				if(w[i]>j) {
					f[i][j]=f[i-1][j];
				}else {
					f[i][j]=Math.max(f[i-1][j-w[i]]+v[i], f[i-1][j]);
				}
			}
		}
		System.out.println(f[4][8]);
	}
}
```

## 2、杨辉三角(递归)

<img src="https://gitee.com/lipenghuihenu/picgo-image/raw/master/image-20220307104949498.png" alt="image-20220307104949498" style="zoom: 50%;" />

``` java
public class yanhui {
	//杨辉三角
	private static int f(int x,int y) {
		if(y==0||x==y) {
			return 1;
		}
		return f(x-1,y-1)+f(x-1,y);
	}
	public static void main(String[] args) {
		System.out.println(f(5,2));
	}
}
```

## 3、渡河问题（贪心）

<img src="https://gitee.com/lipenghuihenu/picgo-image/raw/master/image-20220307112739798.png" alt="image-20220307112739798" style="zoom: 67%;" />

<img src="https://gitee.com/lipenghuihenu/picgo-image/raw/master/image-20220307112804448.png" alt="image-20220307112804448" style="zoom: 67%;" />

## 4、DFS

![image-20220307224220579](https://gitee.com/lipenghuihenu/picgo-image/raw/master/image-20220307224220579.png)

#### 4.1 简单全排列

``` java
public class dfs {
	static int n;//1到n的全排列
	static int []ans=new int[30];//用来存答案
	static int []st=new int[30];//记忆数组，如果k没用过,st[k]=0,否则为1
	//dfs求全排列
	private static void dfs(int x) {
		if(x>n) {
			for(int i=1;i<=n;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) {
			if(st[i]==0) {
				st[i]=1;
				ans[x]=i;
				dfs(x+1);
				st[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		dfs(1);
	}
}
```

#### 4.2 带分数问题

``` java
public class dfs_daifenshu {
	static int sum=0;
	static int n;
	static int []st=new int[30];
	static int []ans=new int[30];
	public static void dfs(int x) {
		if(x>9) {
//			for(int i=1;i<=9;i++) {
//				System.out.printf("%5d",ans[i]);
//			}
//			System.out.println();
			for(int i=1;i<=7;i++) {//枚举两个符号的位置
				for(int j=i+1;j<=8;j++) {
					int a=0,b=0,c=0;
					for(int k=1;k<=i;k++) {
						a*=10;
						a+=ans[k];
					}
					for(int k=i+1;k<=j;k++) {
						b*=10;
						b+=ans[k];
					}
					for(int k=j+1;k<=9;k++) {
						c*=10;
						c+=ans[k];
					}
					if(b%c!=0) {
						continue;
					}
					if((a+b/c)==n) {
						sum++;
					}
				}
			}
			return;
		}
		for(int i=1;i<=9;i++) {
			if(st[i]==0) {
				st[i]=1;
				ans[x]=i;
				dfs(x+1);
				st[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		dfs(1);
		System.out.println(sum);
	}
}
```

#### 4.3 N皇后问题

``` java
public class huanghou {
	static int[] st1=new int[30];//记录每一行是否被访问
	static int[] st2=new int[30];//记录每一列是否被访问
	static int[] st3=new int[30];//记录左斜线
	static int[] st4=new int[30];//记录右斜线
	static int[] ans=new int[30];//记录结果
	static int n;
	public static void dfs(int x) {
		if(x>n) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(ans[i]==j) {
						System.out.print("Q");
					}else {
						System.out.print(".");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) {
			if(st1[x]==0&&st2[i]==0&&st3[x+i-1]==0&&st4[n-i+x+1]==0) {
				st1[x]=st2[i]=st3[x+i-1]=st4[n-i+x+1]=1;
				ans[x]=i;
				dfs(x+1);
				st1[x]=st2[i]=st3[x+i-1]=st4[n-i+x+1]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		dfs(1);
	}
}
```

### 剪枝

#### 4.4 木棍拼接问题

```java
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
		for(int i=start;i!=0;i--) {//从大到小开始枚举
			if(st[i]==0&&lenn+s[i]<=len) {
				st[i]=1;
				lenn+=s[i];
				if(dfs(num,lenn,i-1)) {
					return true;
				}
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
```

## 5、前缀和与差分

### 5.1 二维差分

<img src="https://gitee.com/lipenghuihenu/picgo-image/raw/master/image-20220318195125437.png" alt="image-20220318195125437" style="zoom: 67%;" />

<img src="https://gitee.com/lipenghuihenu/picgo-image/raw/master/image-20220318195138772.png" alt="image-20220318195138772" style="zoom:67%;" />

