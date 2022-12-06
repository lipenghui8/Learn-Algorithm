#include <bits/stdc++.h>

using namespace std;

int main()
{
    for(int i=10;i<100;i++)
        if(i+i/10+i%10*10==abs(i-(i/10+i%10*10))+32)
    {
        cout<<i<<endl;
        return 0;
    }

    return 0;
}
