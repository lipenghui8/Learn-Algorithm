#include <iostream>

using namespace std;
int m,n;
int ans;
//±©ËÑ
void dfs(int x,int y)
{
    if(x&1||y&1)
    {
        if(x==m&&y==n)
        {
            ans++;
            return;
        }
        if(x<m)dfs(x+1,y);
        if(y<n)dfs(x,y+1);
    }
}
int main()
{
    cin>>m>>n;
    dfs(1,1);
    cout<<ans;
    return 0;
}
