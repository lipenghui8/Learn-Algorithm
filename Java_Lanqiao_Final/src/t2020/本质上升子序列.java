package t2020;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 本质上升子序列 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			char p=s.charAt(i);
			String k=String.valueOf(p);
			for(int j=i;j<s.length();j++) {
				if(s.charAt(i)>p) {
					k+=p;
					p=s.charAt(j);
				}else {
					map.put(k, 1);
				}
			}
		}
		System.out.println(map.size());
	}
}
