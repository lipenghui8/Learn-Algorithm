#include <bits/stdc++.h>
using namespace std;
int a[100000];
int gcd(int a,int b)
{
    return b>0?gcd(b,a%b):a;
}
int main()
{
    int n,d;
    scanf("%d",&n);
    for(int i=0;i<n;i++)
        scanf("%d",&a[i]);
    sort(a,a+n);
    d=a[1]-a[0];
    for(int i=1;i<n-1;i++)
        d=gcd(d,a[i+1]-a[i]);
    if(!d)
        cout<<n;
    else
        cout<<(a[n-1]-a[0])/d+1;
    return 0;
}
