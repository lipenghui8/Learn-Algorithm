#include <iostream>
#include <cstdio>
using namespace std;
int m,n,p,q,mins=9999;//m,n表示数组大小，p,q表示终点坐标,mins表示最短路径的长度
int a[100][100];//存放地图数据，1表示空地，2表示障碍物
int v[100][100];//访问数组，0表示未访问，1表示已访问
int dx[4]={0,1,0,-1};//方向数组，表示顺时针右、下、左、上
int dy[4]={1,0,-1,0};
void dfs(int x,int y,int step)
{
    if(x==p&&y==q)//处理到达终点的情况
    {
        if(step<mins)
            mins=step;
        return;
    }
    //顺时针试探
    for(int k=0;k<=3;k++)
    {
        int tx,ty;//表示下一个方向
        tx=x+dx[k];
        ty=y+dy[k];
        if(a[tx][ty]==1&&v[tx][ty]==0)
        {
            v[tx][ty]=1;
            dfs(tx,ty,step+1);
            v[tx][ty]=0;
        }
    }
    return;
}
int main()
{
    int startx,starty;//起点坐标
    scanf("%d%d",&m,&n);
    for(int i=1;i<=m;i++)
        for(int j=1;j<=n;j++)
            scanf("%d",&a[i][j]);//1表示空地，2表示障碍物
    scanf("%d%d%d%d",&startx,&starty,&p,&q);
    v[startx][starty]=1;//设置起点坐标已访问
    dfs(startx,starty,0);
    printf("%d",mins);
    return 0;
}
/*
测试样例
5 4
1 1 2 1
1 1 1 1
1 1 2 1
1 2 1 1
1 1 1 2
1 1 4 3
*/
