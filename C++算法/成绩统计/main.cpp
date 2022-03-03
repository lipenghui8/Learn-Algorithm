#include <iostream>

using namespace std;

int ans(int a)
{
    if(a%10>=5)
        return a/10+1;
    else
        return a/10;
}
int main()
{
    int n,a;
    cin>>n;
    int sumx=0,sumy=0;
    int p=n;
    while(p--)
    {
        cin>>a;
        if(a>=60)
            sumx++;
        if(a>=85)
            sumy++;
    }
    int p1=(sumx*1000/n);
    int p2=(sumy*1000/n);
    cout<<ans(p1)<<"%"<<endl;
    cout<<ans(p2)<<"%"<<endl;
    return 0;
}
