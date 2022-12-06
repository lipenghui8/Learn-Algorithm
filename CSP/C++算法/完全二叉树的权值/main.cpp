#include <bits/stdc++.h>

using namespace std;
const int N=100000;
typedef long long ll;

ll p[N];
int main()
{
    ll n;
    scanf("%lld",&n);
    for(int i=1;i<=n;i++)
        scanf("%lld",&p[i]);
    ll maxn=-1e20;
    ll deep=1;
    ll res=0;
    for(int i=1;i<=n;i*=2)
    {
        ll sum=0;
        for(int j=i;j<i*2&&j<=n;j++)
            sum+=p[j];
        if(sum>maxn)
        {
            maxn=sum;
            res=deep;
        }
        deep++;
    }
    printf("%lld",res);
    return 0;
}
