#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<int,int> pii;
typedef double db;
int n;
vector<int> ans;
void show()
{
    for(int i=0;i<ans.size();i++)
        printf("%5d",ans[i]);
    putchar('\n');
    return;
}
int vis[12];
void dfs(int num)
{
    if(num==n+1)
    {
        show();
        return;
    }
    for(int i=1;i<=n;i++)
    {
        if(!vis[i])
        {
            ans.push_back(i);
            vis[i]=1;
            dfs(num+1);
            ans.pop_back();
            vis[i]=0;
        }
    }
}
int main()
{
    cin>>n;
    dfs(1);
    return 0;
}
