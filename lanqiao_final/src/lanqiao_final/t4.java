package lanqiao_final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class node{
	int pid,t,l,h,w,vl,sta=1;
	public node(int pid,int t,int l,int h,int w,int vl,int sta) {
		this.pid=pid;
		this.t=t;
		this.l=l;
		this.h=h;
		this.w=w;
		this.vl=vl;
		this.sta=sta;
	}
}

public class t4 {
	static ArrayList<node> s=new ArrayList<>();
	static int find(int pid) {
		for(int i=0;i<s.size();i++) {
			if(s.get(i).pid==pid) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		int vl=1;		
		for(int i=1;i<=k;i++) {
			String d=sc.next();
			if(d.equals("new")) {
				int p=sc.nextInt(),t=sc.nextInt(),l=sc.nextInt(),h=sc.nextInt(),w=sc.nextInt();
				s.add(new node(p, t, l, h, w,vl,1));
				vl++;
			}else if(d.equals("move")) {
				int pid=sc.nextInt(),v=sc.nextInt(),h=sc.nextInt();
				int di=find(pid);
				if(di!=-1&&s.get(di).sta==1) {
					node ssNode=s.get(di);
					s.set(di, new node(pid, ssNode.t+v, ssNode.l+h, ssNode.h,ssNode.w,vl,1));
					vl++;
				}
			}else if(d.equals("resize")) {
				int pid=sc.nextInt(),h=sc.nextInt(),w=sc.nextInt();
				int di=find(pid);
				if(di!=-1&&s.get(di).sta==1) {
					node ssNode=s.get(di);
					s.set(di, new node(pid, ssNode.t, ssNode.l, h,w,vl,1));
					vl++;
				}
			}else if(d.equals("close")) {
				int pid=sc.nextInt();
				int di=find(pid);
				if(di!=-1&&s.get(di).sta==1) {
					node ssNode=s.get(di);
					s.set(di, new node(pid, ssNode.t, ssNode.l, ssNode.h,ssNode.w,ssNode.vl,0));
				}
			}else if(d.equals("active")) {
				int pid=sc.nextInt();
				int di=find(pid);
				if(di!=-1) {
					node ssNode=s.get(di);
					s.set(di, new node(pid, ssNode.t, ssNode.l, ssNode.h,ssNode.w,vl,1));
					vl++;
				}
			}
		}
		char[][] str=new char[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				str[i][j]='.';
			}
		}
		
		s.sort(new Comparator<node>() {
			public int compare(node o1, node o2) {
			if(o1.vl<o2.vl) {
				return -1;
			}else {
				return 1;
			}
		}
		});
		
		for(int q=0;q<s.size();q++) {
			node nn=s.get(q);
			if(nn.sta==1) {
				int t=nn.t;
				int l=nn.l;
				int h=nn.h;
				int w=nn.w;
				int f1=0,f2=0,f3=0,f4=0;
				if(t>=0&&t<n&&l>=0&&l<m) {//zuoshang
					str[t][l]='+';
					f1=1;
				}
				int t2=t+h-1,l2=l;
				if(t2>=0&&t2<n&&l2>=0&&l2<m) {//zuoxia
					str[t2][l2]='+';
					f2=1;
				}
				int t3=t,l3=l+w-1;
				if(t3>=0&&t3<n&&l3>=0&&l3<m) {
					str[t3][l3]='+';
					f3=1;
				}
				int t4=t+h-1,l4=l+w-1;
				if(t4>=0&&t4<n&&l4>=0&&l4<m) {
					str[t4][l4]='+';
					f4=1;
				}
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						if(i>t&&i<t4&&j>l&&j<l4) {
							str[i][j]=' ';
						}else if(i==t&&j>l&&j<l3) {
							str[i][j]='-';
						}else if(i==t2&&j>l2&&j<l4) {
							str[i][j]='-';
						}else if(j==l&&i>t&&i<t2) {
							str[i][j]='|';
						}else if(j==l3&&i>t3&&i<t4) {
							str[i][j]='|';
						}
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(str[i][j]);
			}
			System.out.println();
		}
	}
}
