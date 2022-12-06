#include <bits/stdc++.h>

using namespace std;
struct node{
    int p;
    int flag=0;
    set<int> res;
}s[100001];
int n;
int res=0,sum=0;
int sump=0;
int v[100001];

void bfs()
{
    queue<node> q;
    q.push(s[1]);
    v[1]=1;
    while(!q.empty())
    {
        node xx=q.front();
        q.pop();
        if(xx.flag==0){
            sum+=xx.p;
            for(set<int>::iterator it=xx.res.begin();it!=xx.res.end();it++)
            {
                s[*it].flag=1;
            }
        }
        for(set<int>::iterator it=xx.res.begin();it!=xx.res.end();it++)
        {
            if(v[*it]==0)
            {
                v[*it]=1;
                q.push(s[*it]);
            }
        }
    }
}

int main()
{
    cin>>n;
    for(int i=1;i<=n;i++){
        cin>>s[i].p;
        sump+=s[i].p;
    }
    int x,y;
    for(int i=1;i<n;i++){
        cin>>x>>y;
        s[x].res.insert(y);
        s[y].res.insert(x);
    }
    bfs();
    cout<<max(sump-sum,sum);
    return 0;
}
