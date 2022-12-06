#include <iostream>

using namespace std;

void hannuo(int n,char a,char b,char c)
{
    if(n==1)
        cout<<a<<"->"<<c<<endl;
    else
    {
        hannuo(n-1,a,c,b);
        cout<<a<<"->"<<c<<endl;
        hannuo(n-1,b,a,c);
    }
}

int main()
{
    while(1)
    {
        char a,b,c;
        int n;
        cin>>n;
        hannuo(n,'a','b','c');
    }
    return 0;
}
