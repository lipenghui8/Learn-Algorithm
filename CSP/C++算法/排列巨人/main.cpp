#include<bits/stdc++.h>
using namespace std;

struct z
{
    int a,s;
}p[10000];
int d[300000];
bool cmp(z &a,z &b)
{
    return a.s>b.s;
}
int main(){
    int n,m;
    scanf("%d %d",&n,&m);
    for(int i=0;i<n;++i)
        scanf("%d %d",&p[i].a,&p[i].s);
    for(int i=0;i<m;++i)
        scanf("%d",&d[i]);
    sort(p,p+n,cmp);
    sort(d,d+m);
    int sum=0;
    for(int i=0;i<n;++i)
    {
        for(int j=0;j<m;++j)
        {
            if(p[i].a<=d[j])
            {
                sum+=p[i].s;
                d[j]=0;
                break;
            }
        }
    }
    printf("%d",sum);
	return 0;
}
