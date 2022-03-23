package t2019;

import java.util.Set;
import java.util.TreeSet;

public class 不同子串 {
	static String a="0100110001010001";
	static Set<String> set=new TreeSet<>();
	public static void main(String[] args) {
		for(int i=0;i<a.length();i++) {
			for(int j=i+1;j<=a.length();j++){
				String ssString=a.substring(i,j);
				set.add(ssString);
			}
		}
		System.out.println(set.size());
	}
}
