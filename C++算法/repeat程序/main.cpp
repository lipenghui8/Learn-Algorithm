#include <iostream>

using namespace std;

int main()
{
    int a=0;
    for(int i=0;i<2;i++)
    {
        a+=4;
        for(int j=0;j<5;j++)
        {
            for(int k=0;k<6;k++)
                a+=5;
            a+=7;
        }
        a+=8;
    }
    a+=9;
    cout<<a;
    return 0;
}
