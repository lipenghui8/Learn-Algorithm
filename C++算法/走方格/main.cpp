#include <iostream>
#include <cstdio>
using namespace std;
int m,n,p,q;//m,n��ʾ�����С��p,q��ʾ�յ�����,mins��ʾ���·���ĳ���
int v[31][31];//�������飬0��ʾδ���ʣ�1��ʾ�ѷ���
int dx[4]={0,1};//�������飬��ʾ˳ʱ���ҡ��¡�����
int dy[4]={1,0};
int sum=0;
void dfs(int x,int y)
{
    if(x==p&&y==q)//�������յ�����
    {
        sum++;
        return;
    }
    //˳ʱ����̽
    for(int k=0;k<=1;k++)
    {
        int tx,ty;//��ʾ��һ������
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
    v[1][1]=1;//������������ѷ���
    dfs(1,1);
    printf("%d",sum);
    return 0;
}
