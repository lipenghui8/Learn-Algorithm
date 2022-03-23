package t2019;

public class 数列求值 {
	public static void main(String[] args) {
		int p=1,q=1,r=1,s=0;
		for(int i=4;i<=20190324;i++) {
			s=(p+q+r)%10000;
			p=q%10000;
			q=r%10000;
			r=s;
		}
		System.out.println(s);
	}
}
