#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int a[900000];
int main()
{
    int n,m;
    ll sum=0;
    scanf("%d%d",&n,&m);
    int s=n+m+1;
    for(int i=0;i<s;i++)
        scanf("%d",&a[i]);
    if(!m)
    {
        for(int i=0;i<s;i++)
            sum+=a[i];
        printf("%lld\n",sum);
        return 0;
    }
    sort(a,a+s);
    sum=a[s-1]-a[0];
    for(int i=1;i<s-1;i++)
        sum+=abs(a[i]);
    printf("%lld\n",sum);
    return 0;
}
