#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
char a[100000];
ll check(int i,int j)
{
    char b[j-i+1];
    int len=j-i+1;
    for(int p=0;p<len;p++)
        b[p]=a[i+p];
    sort(b,b+len);
    ll n=unique(b,b+len)-b;
    return n;
}
int main()
{
    cin>>a;
    ll sum=0;
    int len=strlen(a);
    for(int i=0;i<len;i++)
    {
        for(int j=i;j<len;j++)
        {
            sum+=check(i,j);
        }
    }
    cout<<sum<<endl;
    return 0;
}
