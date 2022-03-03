#include <bits/stdc++.h>

using namespace std;

int check(int n)
{
    int sum=0;
    while(n)
    {
        if(n%10==2)
            sum++;
        n=n/10;
    }
    return sum;
}
int main()
{
    int sum=0;
    for(int i=1;i<=2020;i++)
    {
        sum+=check(i);
    }
    cout<<sum;
    return 0;
}
