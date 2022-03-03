#include <iostream>

using namespace std;

int main()
{
    int n=10000,sum=0;
    while(n>=600)
    {
        n-=300;
        sum+=2*60;
    }
    sum+=n/10;
    cout<<sum;
    return 0;
}
