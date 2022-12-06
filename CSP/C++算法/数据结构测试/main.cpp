#include <bits/stdc++.h>

using namespace std;

int main()
{
    stack<int> a;
    for(int i=0;i<10;i++)
        a.push(i);
    for(int i=0;i<10;i++)
    {
        cout<<a.top()<<" ";
        a.pop();
    }
    return 0;
}
