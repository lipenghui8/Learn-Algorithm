#include <iostream>
#include <set>

using namespace std;
struct node{
    int p;
    set<int> res;
}s[100001];
int n;
int sump=0;
int v[100001];

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
    long sum=0;
    for(int i=1;i<=n;i++){
        if(v[i]==0)
        {
            v[i]=1;
            sum+=s[i].p;
            for(set<int>::iterator it=s[i].res.begin();it!=s[i].res.end();it++){
                v[*(it)]=1;
            }
        }
    }
    cout<<max(sum,sump-sum);
    return 0;
}
