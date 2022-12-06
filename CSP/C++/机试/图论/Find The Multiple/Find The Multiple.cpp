#include<iostream>
#include<queue>
using namespace std;
int n;
typedef long long LL;

LL bfs(int x) 
{
    queue<int> q;
    q.push(1);
    while (!q.empty()) {
        LL xx = q.front();
        q.pop();
        if (xx % n == 0) {
            return xx;
        }
        q.push(xx * 10);
        q.push(xx * 10 + 1);
    }
}
int main()
{
    
    while (cin >> n && n != 0) {
        cout<<bfs(n)<<endl;
    }
    return 0;
}