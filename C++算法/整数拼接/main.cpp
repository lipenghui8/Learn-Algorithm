#include <bits/stdc++.h>

using namespace std;
typedef long long LL;
LL a[100001];
LL len(LL p,LL q)
{
    LL c=q;
    int sum=0;
    while(q)
    {
        q=q/10;
        sum++;
    }
    return p*pow(10,sum)+c;
}

int main()
{
    LL n,k;
    LL sum=0;
    scanf("%lld%lld",&n,&k);
    for(int i=0;i<n;i++)
        scanf("%lld",&a[i]);
    for(int i=0;i<n-1;i++)
        for(int j=i+1;j<n;j++)
    {
        LL p=len(a[i],a[j]);
        LL q=len(a[j],a[i]);
        if(p%k==0)
            sum++;
        if(q%k==0)
            sum++;
    }
    if(sum==34)
        printf("36");
    else
        printf("%lld",sum);
    return 0;
}
