#include <bits/stdc++.h>

using namespace std;
int n,k;
const int Q=1e9;
int gcd(int a,int b)
{
    return b>0?gcd(b,a%b):a;
}
int f(int a)
{
    if(a==1)
        return 1;
    else{
        int sum=0;
        for(int i=1;i<n;i++)
            if(gcd(i,n-i)==1)
                sum++;
        return sum;
    }
}
int g(int a)
{
    int sum=0;
    for(int d=1;d<=n;d++)
    {
        sum+=f(n/d);
    }
    return sum;
}
int G(int k)
{
    if(k==1)
        return f(g(n));
    else if(k>1&&k%2==0)
        return g(G(k-1));
    else if(k>1&&k%2==1)
        return f(G(k-1));
}
int main()
{
    int T;
    cin>>T;
    while(T--)
    {
        cin>>n>>k;
        //cout<<G(k)%Q+7<<endl;
        cout<<g(n)<<endl;
    }
    return 0;
}
