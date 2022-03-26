package t2019;

import java.util.Scanner;

public class 人物相关性分析 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		sc.nextLine();
		String str=sc.nextLine();
		str=str.replace(". ", "! ");
		String[] strs=str.split(" ");
		int sum=0,chars;
		for(int i=0;i<strs.length;i++) {
			if(strs[i].equals("Alice!")||strs[i].equals("Alice")) {
				chars=0;
				//往前找
				for(int j=i-1;j>=0;j--) {
					if(strs[j].equals("Bob")||strs[j].equals("Bob!")) {
						if(strs[j].equals("Bob")&&(chars+1)<=k) {
							sum++;
						}
						else if(strs[j].equals("Bob!")&&(chars+2)<=k) {
							sum++;
						}
					}else {
						chars+=strs[j].length()+1;
					}
				}
				chars=0;
				//往后找
				for(int j=i+1;j<strs.length;j++) {
					if(strs[j].equals("Bob!")||strs[j].equals("Bob")) {
						if(strs[i].equals("Alice!")&&(chars+2)<=k) {
							sum++;
						}else if(strs[i].equals("Alice")&&(chars+1)<=k) {
							sum++;
						}
					}else {
						chars+=strs[j].length()+1;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
