#include <bits/stdc++.h>
using namespace std;

const int N=1e5+5,INF=0x3f3f3f3f;

//快速幂
int quickpow(int a,int p,int mod)
{
    int ans=1;
    a=a%mod;
    while(p)
    {
        if(p&1)
            ans=(ans*a)%mod;
        p>>=1;
        a=(a*a)%mod;
    }
    return ans;
}
//最大公约数
int gcd(int a,int b)
{
    return b>0?gcd(b,a%b):a;
}

int exgcd(int a,int b,int&x,int&y)
{
    if(b==0)
    {
        x=1;y=0;
        return a;
    }
    int r=exgcd(b,a%b,x,y);
    int temp=y; //把x,y变成上一层的
    y=x-(a/b)*y;
    x=temp;
    return r;
}

int inv(int a,int n)
{
    int gcd,x,y;
    gcd=exgcd(a,n,x,y);
    if(gcd==1)
        return ((x%n)+n)%n;//保证最小正整数
    else
        return -1;//没有互质,不存在逆元
}
//二分查找
int binarySearch(int[] nums,int target)
{
    int left=0,right=nums.length-1;
    while(left<=right)
    {
        int mid=left+(right-left)/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]<target)
            left=mid-1;
        else
            right=mid+1;
    }
    return -1;
}
//快速排序
sort(start(a),end(a+length),cmp);//默认从小到大排序，start为开始排序元素的指针，end为结束排序的元素的下一个指针
int cmp(int a,int b){
    return a>b;
}

a%b==0写作 b|a
