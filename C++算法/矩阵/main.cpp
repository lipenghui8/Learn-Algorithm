#include <iostream>

using namespace std;
int dp[1011][1011];
int main()
{
    dp[1][0]=1;
    for(int i=1;i<=1010;i++)dp[i][0]=1;
    for(int i=1;i<=1010;i++)
        for(int j=1;j<=i;j++)
        if(j<i)
            dp[i][j]=(dp[i][j-1]+dp[i-1][j])%2020;
        else
            dp[i][j]=dp[i][j-1];
    cout<<dp[1010][1010]%2020;
    return 0;
}
