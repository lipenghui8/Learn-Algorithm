#include <bits/stdc++.h>

using namespace std;
int a[100];
int dp[100];
int main()
{
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
        scanf("%d",&a[i]);
    for(int i=1;i<=n;i++)
    {
        dp[i]=1;
        for(int j=1;j<i;j++)
            if(a[j]<a[i])
                dp[i]=max(dp[j]+1,dp[i]);
        printf("%d\n",dp[i]);
    }
    return 0;
}
