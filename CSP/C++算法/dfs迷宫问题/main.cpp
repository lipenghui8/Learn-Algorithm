#include <iostream>
#include <cstdio>
using namespace std;
int m,n,p,q,mins=9999;//m,n��ʾ�����С��p,q��ʾ�յ�����,mins��ʾ���·���ĳ���
int a[100][100];//��ŵ�ͼ���ݣ�1��ʾ�յأ�2��ʾ�ϰ���
int v[100][100];//�������飬0��ʾδ���ʣ�1��ʾ�ѷ���
int dx[4]={0,1,0,-1};//�������飬��ʾ˳ʱ���ҡ��¡�����
int dy[4]={1,0,-1,0};
void dfs(int x,int y,int step)
{
    if(x==p&&y==q)//�������յ�����
    {
        if(step<mins)
            mins=step;
        return;
    }
    //˳ʱ����̽
    for(int k=0;k<=3;k++)
    {
        int tx,ty;//��ʾ��һ������
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
    int startx,starty;//�������
    scanf("%d%d",&m,&n);
    for(int i=1;i<=m;i++)
        for(int j=1;j<=n;j++)
            scanf("%d",&a[i][j]);//1��ʾ�յأ�2��ʾ�ϰ���
    scanf("%d%d%d%d",&startx,&starty,&p,&q);
    v[startx][starty]=1;//������������ѷ���
    dfs(startx,starty,0);
    printf("%d",mins);
    return 0;
}
/*
��������
5 4
1 1 2 1
1 1 1 1
1 1 2 1
1 2 1 1
1 1 1 2
1 1 4 3
*/
