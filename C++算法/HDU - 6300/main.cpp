#include <bits/stdc++.h>

using namespace std;

struct tri
{
    int po,x,y;
};
bool cmp(tri a,tri b)
{
    return a.x<b.x;
}
int main()
{
    int T;
    cin>>T;
    while(T--)
    {
        int n;
        cin>>n;
        tri*s=new tri[3*n];
        for(int i=0;i<3*n;i++)
        {
            cin>>s[i].x>>s[i].y;
            s[i].po=i+1;
        }
        sort(s,s+3*n,cmp);
        for(int i=0;i<3*n;)
        {
            cout<<s[i].po<<" "<<s[i+1].po<<" "<<s[i+2].po<<endl;
            i+=3;
        }
    }
    return 0;
}
