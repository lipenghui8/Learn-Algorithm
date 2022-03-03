#include <iostream>

using namespace std;

bool check(int n)
{
    while(n>0)
    {
        if(n%10==2||n%10==4)
            return false;
        else n=n/10;
    }
    return true;
}
int main()
{
    int n=2019;
    int sum=0;
    for(int i=1;i<=2019;i++)
    {
        if(!check(i)) continue;
        else for(int j=i+1;j<2019-i-j;j++)
        {
            int k=n-i-j;
            if(check(j)&&check(k))
                sum++;
        }
    }
    cout<<sum;
    return 0;
}
