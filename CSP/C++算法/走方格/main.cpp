#include <iostream>
#include <cstdio>
using namespace std;
int m,n,p,q;//m,n表示数组大小，p,q表示终点坐标,mins表示最短路径的长度
int v[31][31];//访问数组，0表示未访问，1表示已访问
int dx[4]={0,1};//方向数组，表示顺时针右、下、左、上
int dy[4]={1,0};
int sum=0;
void dfs(int x,int y)
{
    if(x==p&&y==q)//处理到达终点的情况
    {
        sum++;
        return;
    }
    //顺时针试探
    for(int k=0;k<=1;k++)
    {
        int tx,ty;//表示下一个方向
        tx=x+dx[k];
        ty=y+dy[k];
        if((tx&1||ty&1)&&(tx<=m&&ty<=n)&&v[tx][ty]==0)
        {
            v[tx][ty]=1;
            dfs(tx,ty);
            v[tx][ty]=0;
        }
    }
    return;
}
int main()
{
    scanf("%d%d",&m,&n);
    p=m;
    q=n;
    v[1][1]=1;//设置起点坐标已访问
    dfs(1,1);
    printf("%d",sum);
    return 0;
}
