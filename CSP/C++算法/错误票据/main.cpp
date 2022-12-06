#include <bits/stdc++.h>

using namespace std;
const int N=1e5+5,INF=0x3f3f3f3f;
int a[N];
int main()
{
    int n;
    cin>>n;
    int k,i=0;
    while(cin>>k)
    {
        a[i++]=k;
    }
    int len=sizeof(a)/sizeof(a[0]);
    sort(a,a+len);
    int ansm,ansn;
    for(int i=1;i<len;i++)
    {
        if(a[i]==a[i-1])
            ansn=a[i];
        else if(a[i]==a[i-1]+2)
            ansm=a[i]-1;
    }
    cout<<ansm<<" "<<ansn<<endl;
    return 0;
}
