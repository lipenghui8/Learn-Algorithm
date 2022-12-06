#include <bits/stdc++.h>

using namespace std;
int a[100][100];//存放地图数据,1表示空地，2表示障碍物，0为边界
int v[100][100];//访问数组
struct point
{
    int x;
    int y;
    int step;
};
queue<point> r;//申请队列
int dx[4]={0,1,0,-1};//定义方向数组，右、下、左、上
int dy[4]={1,0,-1,0};
int main()
{
    int m,n;
    int startx,starty,p,q;//起点和终点坐标
    //输入m行n列
    scanf("%d%d",&m,&n);
    for(int i=1;i<=m;i++)
        for(int j=1;j<=n;j++)
            scanf("%d",&a[i][j]);
    scanf("%d%d%d%d",&startx,&starty,&p,&q);
    //BFS
    point start;//定义起点
    start.x=startx;
    start.y=starty;
    start.step=0;
    r.push(start);//起点入队
    v[startx][starty]=1;//将起点设置为已访问

    int flag=0;//定义标记，记录是否存在解
    while(!r.empty())
    {
        int x=r.front().x,y=r.front().y;//取出队首元素
        if(x==p&&y==q)//当到达终点时退出循环
        {
            flag=1;
            printf("%d",r.front().step);
            break;
        }
        for(int k=0;k<=3;k++)
        {
            int tx,ty;//定义拓展方向
            tx=x+dx[k];
            ty=y+dy[k];
            if(a[tx][ty]==1&&v[tx][ty]==0)
            {
                //入队
                point temp;//定义拓展的点
                temp.x=tx;
                temp.y=ty;
                temp.step=r.front().step+1;
                r.push(temp);
                v[tx][ty]=1;
            }
        }
        r.pop();//拓展完了将队首元素出队
    }
    if(flag==0)
        printf("no answer!");
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
