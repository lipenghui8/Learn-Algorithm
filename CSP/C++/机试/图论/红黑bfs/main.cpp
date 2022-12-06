#include <iostream>

using namespace std;
int m,n;
int dx[]={-1,1,0,0};
int dy[]={0,0,-1,1};
char s[30][30];
int sum;

struct node{
    int x,y;
};
void bfs(int x,int y)
{
    queue<node> q;
    q.push({1,1});
    while(!)
}
int main()
{
    cin>>m>>n;
    for(int i=1;i<=m;i++)
    {
        for(int j=1;j<=n;j++)
        {
            cin>>s[i][j];
        }
    }
    bfs();
    return 0;
}
