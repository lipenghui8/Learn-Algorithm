#include<bits/stdc++.h>
using namespace std;
int city[1001][1001];
int visit[1001];
int n, m, k, a, b;
void dfs(int p) {
    for (int i = 1; i <= n; i++) {
        if (city[p][i] == 1 && visit[i] == 0) {
            visit[i] = 1;
            dfs(i);
        }
    }
}
int main()
{
    cin >> n >> m >> k;
    for (int i = 1; i <= m; i++) {
        cin >> a >> b;
        city[a][b] = city[b][a] = 1;
    }
    int t;
    for (int i = 0; i < k; i++) {
        cin >> t;
        memset(visit, 0, sizeof(visit));
        visit[t] = 1;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0) {
                dfs(i);
                cnt++;
            }
        }
        cout << cnt - 1<<endl;
    }
    return 0;
}