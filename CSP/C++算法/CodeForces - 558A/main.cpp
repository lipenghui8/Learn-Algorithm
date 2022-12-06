#include <bits/stdc++.h>

using namespace std;

struct tmp1
{
    int x;
    tmp1(int a){x=a;}
    bool operator<(const tmp1&a)const
    {
        return x<a.x;
    }
};
struct tmp2
{
    bool operator()(tmp1 a,tmp1 b)
    {
        return a.x<b.x;
    }
};
int main()
{
    priority_queue<tmp1> d;
    priority_queue<tmp1,vector<tmp1>,tmp2> f;
    return 0;
}
