#include <bits/stdc++.h>

using namespace std;
#define MAXN 20001
int fa[MAXN];
void init(int n)
{
    for(int i=1;i<=n;i++)
        fa[i]=i;
}
int findx(int x)
{
    if(x==fa[x])
        return x;
    else{
        fa[x]=findx(fa[x]);//父节点设为根节点
        return fa[x];//返回父节点
    }
}
void unionn(int i,int j)
{
    int i_fa=findx(i);
    int j_fa=findx(j);
    fa[i_fa]=j_fa;
}
int main()
{
    int n,m,x,y,q;
    scanf("%d",&n);
    init(n);
    scanf("%d",&m);
    for(int i=1;i<=m;i++)
    {
        scanf("%d%d",&x,&y);
        unionn(x,y);
    }
    scanf("%d",&q);
    for(int i=1;i<=q;i++)
    {
        scanf("%d%d",&x,&y);
        if(findx(x)==findx(y))
            printf("Yes\n");
        else
            printf("No\n");
    }
    return 0;
}
