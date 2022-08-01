#include<bits/stdc++.h>
using namespace std;
int n, m;
vector<int> s[100010];
int res[100010];

void bfs(int x,int k) {
    queue<int> q;
    q.push(x);
    while (!q.empty()) {
        int xx = q.front();
        res[xx] = k;
        q.pop();
        for (int i = 0; i < s[xx].size(); i++) {
            int t = s[xx][i];
            if (res[t] == 0) {
                q.push(t);
            }
        }
    }
}
int main()
{
    cin >> n >> m;
    for (int i = 1; i <= m; i++) {
        int a, b;
        cin >> a >> b;
        s[b].push_back(a);
    }
    for (int i = n; i; i--) {
        if (res[i] == 0) {
            bfs(i, i);
        }
    }
    for (int i = 1; i <=n; i++) {
        cout << res[i] << " ";
    }
    return 0;
}