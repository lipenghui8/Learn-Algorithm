#include <iostream>
#include <cstdio>

using namespace std;

bool check(int n)
{
    while(n)
    {
        int t=n%10;
        if(t==2||t==0||t==1||t==9)
            return true;
        n/=10;
    }
    return false;
}
int main()
{
    int n,sum=0;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
    {
        if(check(i))
            sum+=i;
    }
    printf("%d",sum);
    return 0;
}
