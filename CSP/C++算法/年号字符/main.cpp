#include <iostream>
#include <stack>

using namespace std;

int main()
{
    int n=28;
    stack<int> s;
    while(n)
    {
        s.push(n%26);
        n=n/26;
    }
    while(!s.empty())
    {
        cout<<char(s.top()+64);
        s.pop();
    }
    return 0;
}
