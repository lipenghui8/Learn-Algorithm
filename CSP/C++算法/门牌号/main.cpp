#include <iostream>

using namespace std;

int main()
{
    int sum=0;
    for(int i=1;i<=2020;i++)
    {
        int j=i;
        while(j!=0)
        {
            if(j%10==2)
                sum++;
            j/=10;
        }
    }
    cout<<sum;
    return 0;
}
