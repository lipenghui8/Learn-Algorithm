#include <iostream>

using namespace std;

int main()
{
    int sum=1;
    int d=4;
    for(int i=2;i<=20;i++)
    {
        sum+=d;
        d+=4;
    }
    cout<<sum;
    return 0;
}
