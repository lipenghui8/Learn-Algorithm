#include <bits/stdc++.h>

using namespace std;
int w[100];
int v[100];
int dp[100][100];
int main()
{
    int n,k;
    scanf("%d%d",&n,&k);
    for(int i=1;i<=k;i++)
    {
        scanf("%d%d",&w[i],&v[i]);
    }
    for(int i=1;i<=k;i++)
        for(int j=1;j<=n;j++)
    {
        if(j>=w[i])
            dp[i][j]=max(dp[i-1][j-w[i]]+v[i],dp[i-1][j]);
        else
            dp[i][j]=dp[i-1][j];
    }
    printf("%d",dp[k][n]);
    return 0;
}
