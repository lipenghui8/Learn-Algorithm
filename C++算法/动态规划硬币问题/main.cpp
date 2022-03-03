#include <bits/stdc++.h>

using namespace std;
int dp[4][100];
int main()
{
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
    {
        dp[i][1]=1+dp[i-1][1];
        if(i>=5)
            dp[i][2]=1+dp[i-5][2];
        else
            dp[i][2]=999999;
        if(i>=11)
            dp[i][3]=1+dp[i-11][3];
        else
            dp[i][3]=999999;
        dp[i][0]=min(dp[i][1],min(dp[i][2],dp[i][3]));
    }
    printf("%d",dp[n][0]);
    return 0;
}
