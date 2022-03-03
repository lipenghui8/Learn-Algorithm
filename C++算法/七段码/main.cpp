#include <bits/stdc++.h>

using namespace std;
const int N=10;
int use[N],ans=0,e[N][N],fa[N];
void init()
{
    /*
		连边建图，e[i][j]==1表示i和j相邻
		a b c d e f g
		1 2 3 4 5 6 7
	*/
	e[1][2]=e[1][6]=1;
	e[2][1]=e[2][7]=e[2][3]=1;
	e[3][2]=e[3][4]=e[3][7]=1;
	e[4][3]=e[4][5]=1;
	e[5][4]=e[5][6]=e[5][7]=1;
	e[6][1]=e[6][5]=e[6][7]=1;
}
int findx(int u)
{
    if(fa[u]==u)
        return u;
    else
    {
        fa[u]=findx(fa[u]);
        return fa[u];
    }
}
void dfs(int d)
{
    if(d>7)
    {
        for(int i=1;i<=7;i++) fa[i]=i;
        for(int i=1;i<=7;i++)
            for(int j=1;j<=7;j++)
            if(e[i][j]&&use[i]&&use[j])
        {
            int fx=findx(i),fy=findx(j);
            if(fx!=fy)
                fa[fx]=fy;
        }
        int k=0;
        for(int i=1;i<=7;i++)
            if(use[i]&&fa[i]==i)
                k++;
        if(k==1)
            ans++;
        return;
    }
    use[d]=1;
    dfs(d+1);
    use[d]=0;
    dfs(d+1);
}
int main()
{
    init();
    dfs(1);
    cout<<ans;
    return 0;
}
