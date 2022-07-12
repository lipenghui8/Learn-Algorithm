package t2020;

public class 美丽的2 {
	public static void main(String[] args) {
		int cnt=0;
		for(int i=1;i<=2020;i++) {
			String s=String.valueOf(i);
			if(s.contains("2")) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
