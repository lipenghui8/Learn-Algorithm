package 二刷_2020_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class 寻找2020 {
	static char[][] a=new char[10000][10000];
	static int sum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\86155\\eclipse-workspace\\Java-LanQiao\\mi.txt")));
		String s="";
		int k=0;
		while((s=bf.readLine())!=null) {
			a[k]=s.toCharArray();
			k++;
		}
		for(int i=0;i<k;i++) {
			for(int j=0;j<k;j++) {
				if(a[i][j]=='2') {
					if(i+3<k&&a[i+1][j]=='0'&&a[i+2][j]=='2'&&a[i+3][j]=='0') {
						sum++;
					}
					if(j+3<k&&a[i][j+1]=='0'&&a[i][j+2]=='2'&&a[i][j+3]=='0') {
						sum++;
					}
					if(i+3<k&&j+3<k&&a[i+1][j+1]=='0'&&a[i+2][j+2]=='2'&&a[i+3][j+3]=='0') {
						sum++;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
