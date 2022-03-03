#include <bits/stdc++.h>

using namespace std;
int a[100][100];//��ŵ�ͼ����,1��ʾ�յأ�2��ʾ�ϰ��0Ϊ�߽�
int v[100][100];//��������
struct point
{
    int x;
    int y;
    int step;
};
queue<point> r;//�������
int dx[4]={0,1,0,-1};//���巽�����飬�ҡ��¡�����
int dy[4]={1,0,-1,0};
int main()
{
    int m,n;
    int startx,starty,p,q;//�����յ�����
    //����m��n��
    scanf("%d%d",&m,&n);
    for(int i=1;i<=m;i++)
        for(int j=1;j<=n;j++)
            scanf("%d",&a[i][j]);
    scanf("%d%d%d%d",&startx,&starty,&p,&q);
    //BFS
    point start;//�������
    start.x=startx;
    start.y=starty;
    start.step=0;
    r.push(start);//������
    v[startx][starty]=1;//���������Ϊ�ѷ���

    int flag=0;//�����ǣ���¼�Ƿ���ڽ�
    while(!r.empty())
    {
        int x=r.front().x,y=r.front().y;//ȡ������Ԫ��
        if(x==p&&y==q)//�������յ�ʱ�˳�ѭ��
        {
            flag=1;
            printf("%d",r.front().step);
            break;
        }
        for(int k=0;k<=3;k++)
        {
            int tx,ty;//������չ����
            tx=x+dx[k];
            ty=y+dy[k];
            if(a[tx][ty]==1&&v[tx][ty]==0)
            {
                //���
                point temp;//������չ�ĵ�
                temp.x=tx;
                temp.y=ty;
                temp.step=r.front().step+1;
                r.push(temp);
                v[tx][ty]=1;
            }
        }
        r.pop();//��չ���˽�����Ԫ�س���
    }
    if(flag==0)
        printf("no answer!");
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
