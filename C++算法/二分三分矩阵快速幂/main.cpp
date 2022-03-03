#include <bits/stdc++.h>

using namespace std;

int main()
{
    int a[100];
    for(int i=0;i<100;i++)
        a[i]=i+1;
    int firstLoc=lower_bound(a,a+100,67)-a;
    int lastLoc=upper_bound(a,a+100,67)-a;
    cout<<firstLoc<<" "<<lastLoc<<endl;
    return 0;
}
