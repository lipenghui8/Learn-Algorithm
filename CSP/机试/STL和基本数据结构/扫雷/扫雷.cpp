#include<bits/stdc++.h>
using namespace std;
const int N = 5e4 + 1;
int n, m;
struct node
{
    int x, y, r;
};
node s[N], w[N];
int v[N],cnt;
int bfs(node k) {
    queue<node> q;
    int sum = 0;
    q.push(k);
    while (!q.empty())
    {
        node c = q.front();
        q.pop();
        int xx = c.x, yy = c.y, rr = c.r;
        for (int i = max(0,xx-rr); i <= xx+rr; i++) {
            for (int j = max(0, yy - rr); j <= yy + rr; j++) {
                for (int t = 0; t < n; t++){
                    if (v[t] == 0 && w[t].x == i && w[t].y == j) {
                        v[t] = 1;
                        q.push(w[t]);
                        sum++;
                    }
                }
            }
        }
    }
    return sum;
}
int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> s[i].x >> s[i].y >> s[i].r;
    }
    for (int i = 0; i < m; i++) {
        cin >> w[i].x >> w[i].y >> w[i].r;
    }
    for (int i = 0; i < n; i++) {
        cnt += bfs(s[i]);
    }
    cout << cnt;
    return 0;
}