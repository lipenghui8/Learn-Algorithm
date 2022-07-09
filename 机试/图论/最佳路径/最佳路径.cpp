#include<iostream>
#include<queue>
#define M 100000
using namespace std;
int n, k;
int v[M+1];
int s[M+1];

void bfs(int first, int last)
{
    memset(v, 0, sizeof(v));
    memset(s, 0, sizeof(s));
    queue<int> q;
    q.push(first);
    v[first] = 1;
    while (!q.empty())
    {
        int now = q.front();
        q.pop();
        if (now==last) {
            break;
        }
        if ((now+1)<=M&&v[now + 1] == 0) {
            v[now + 1] = 1;
            s[now + 1] = s[now] + 1;
            q.push(now + 1);
        }
        if (now - 1 >= 0 && v[now - 1] == 0) {
            v[now - 1] = 1;
            s[now - 1] = s[now] + 1;
            q.push(now - 1);
        }
        if (now * 2 <= M && v[now * 2] == 0) {
            v[now * 2] = 1;
            s[now * 2] = s[now] + 1;
            q.push(now*2);
        }
    }
}
int main()
{
    while (cin >> n >> k) {
        if (n >= k) {
            cout << n - k<<endl;
            continue;
        }
        bfs(n, k);
        cout << s[k]<<endl;
    }
    return 0;
}