package 常用算法;

import java.util.Arrays;

public class erfen {
	private static int binarySearch(int[]arr,int x) {
		int l=0,r=arr.length-1,ans=-1;
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(arr[mid]==x) {
				ans=mid;
				break;
			}else if(arr[mid]<x){
				l=mid+1;
			}else {
				r=mid-1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int []a= {3,1,2,7,4,5,9,2};
		Arrays.sort(a);
		System.out.println(binarySearch(a, 2));
	}
}
