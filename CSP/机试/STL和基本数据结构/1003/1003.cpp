#include<bits/stdc++.h>
using namespace std;

int bfs(int c1,int c2) {
    queue<int> q;
    q.push(c1);
    while (!q.empty()) {
        int t = q.front();
        q.pop();

    }
}

int main()
{
    int n, m, c1, c2;
    int re[501] = { 0 };
    int ro[501][501] = { 0 };
    cin >> n >> m >> c1 >> c2;
    for (int i = 0; i < n; i++) {
        cin >> re[i];
    }
    for (int i = 0; i < m; i++) {
        int p, q;
        cin >> p >> q;
        cin >> ro[p][q];
    }

    return 0;
}