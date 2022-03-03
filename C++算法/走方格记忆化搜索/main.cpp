#include <iostream>

using namespace std;
int m,n;
int f[31][31];
int dfs(int x,int y)
{
    if(x&1||y&1)
    {
        if(f[x][y])return f[x][y];
        if(x<m) f[x][y]+=dfs(x+1,y);
        if(y<n) f[x][y]+=dfs(x,y+1);
    }
    return f[x][y];
}
int main()
{
    cin>>m>>n;
    f[m][n]=m&1||n&1;
    cout<<dfs(1,1)<<endl;
    return 0;
}
