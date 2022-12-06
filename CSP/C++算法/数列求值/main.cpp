#include <iostream>

using namespace std;

int main()
{
    int n=20190324;
    int num[3]={1,1,1};
    int k;
    for(int i=4;i<=n;i++)
    {
        k=i%3;
        num[k]=(num[0]+num[1]+num[2])%10000;
    }
    cout<<num[k];
    return 0;
}
