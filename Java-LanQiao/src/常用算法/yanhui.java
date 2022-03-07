package 常用算法;

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
