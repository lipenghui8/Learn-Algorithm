#include <bits/stdc++.h>
#include <bitset>
using namespace std;

int main()
{
    int a,b;
    for(int i=0;i<11;i++)
        for(int j=0;j<16;j++)
    {
        cin>>a>>b;
        bitset<8> x(a),y(b);
        cout<<x.to_string()<<y.to_string()<<endl;
    }
    cout<<endl;
    return 0;
}
