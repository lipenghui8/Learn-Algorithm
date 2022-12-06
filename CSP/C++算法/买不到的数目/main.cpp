#include <bits/stdc++.h>

using namespace std;
const int N=1e5+5;
int main()
{
    int m,n;
    cin>>m>>n;
    int a[N];
    int k=0;
    for(int i=0;i<200;i++)
        for(int j=0;j<200;j++)
            a[k++]=m*i+n*j;
    int len=1000;
    sort(a,a+len);
    for(int i=len-1;i>0;i--)
        if(a[i]>=a[i-1]+2&&a[i]<m*n)
        {
            cout<<a[i]-1<<endl;
            break;
        }
    return 0;
}
