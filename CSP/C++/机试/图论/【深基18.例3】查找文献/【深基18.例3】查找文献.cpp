#include<bits/stdc++.h>
using namespace std;
int n, m;
struct nn
{
    int k;
    vector<int> r;
}node[100010];
int v[100010];
void dfs(nn nnode) {
    cout << nnode.k << " ";
    for (int i = 0; i < nnode.r.size(); i++) {
        if (v[nnode.r[i]] == 0) {
            v[nnode.r[i]] = 1;
            dfs(node[nnode.r[i]]);
        }
    }
}
void bfs(nn snode) {
    memset(v, 0, sizeof(v));
    queue<nn> q;
    q.push(snode);
    v[1] = 1;
    while (!q.empty()) {
        nn mnode = q.front();
        cout << mnode.k << " ";
        q.pop();
        for (int i = 0; i < mnode.r.size(); i++) {
            if (v[mnode.r[i]] == 0) {
                v[mnode.r[i]] = 1;
                q.push(node[mnode.r[i]]);
            }
        }
    }
}
int main()
{
    cin >> n >> m;
    int a, b;
    for (int i = 1; i <= n; i++) {
        node[i].k = i;
    }
    for(int i=1;i<=m;i++){
        cin >> a >> b;
        node[a].r.push_back(b);
    }
    for (int i = 1; i <= n; i++) {
        sort(node[n].r.begin(), node[n].r.end());
    }
    v[1] = 1;
    dfs(node[1]);
    cout << endl;
    bfs(node[1]);
    return 0;
}