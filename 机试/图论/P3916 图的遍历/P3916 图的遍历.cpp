#include<bits/stdc++.h>
using namespace std;
int n, m;
vector<int> s[100010];
int v[100010];
int res[100010];
void bfs(int x) {
    queue<int> q;
    vector<int> tle;
    q.push(x);
    tle.push_back(x);
    int maxx = 0;
    memset(v, 0, sizeof(v));
    v[x] = 1;
    while (!q.empty()) {
        int xx = q.front();
        q.pop();
        if (xx > maxx) {
            maxx = xx;
            tle.push_back(t);
        }
        for (int i = 0; i < s[xx].size(); i++) {
            int t = s[xx][i];
            if (v[t] == 0) {
                v[t] = 1;
                q.push(t);
            }
        }
    }
    for (int i = 0; i < tle.size(); i++) {
        res[tle[i]] = maxx;
    }
}
int main()
{
    cin >> n >> m;
    for (int i = 1; i <= m; i++) {
        int a, b;
        cin >> a >> b;
        s[a].push_back(b);
    }
    for (int i = 1; i <= n; i++) {
        if (res[i] == 0) {
            bfs(i);
        }
    }
    for (int i = 1; i <=n; i++) {
        cout << res[i] << " ";
    }
    return 0;
}