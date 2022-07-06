#include <bits/stdc++.h>

using namespace std;

struct node{
    int x,y;
}n;

vector<node> s;
int main()
{
//    node m={1,2};
//    s.push_back(m);
//    cout<<s[0].x<<s[0].y;
//
//    vector<int> v;
//
//    v.push_back(1);
//    for(vector<int>::iterator it=v.begin();it!=v.end();it++){
//        cout<<*it;
//    }
//
//    for(vector<node>::iterator it=s.begin();it!=s.end();it++){
//        cout<<(*it).x;
//    }

    queue<node> q;
    node v={1,2};
    q.push(v);
    node p=q.front();
    q.pop();
    cout<<p.x<<p.y;

    return 0;
}
