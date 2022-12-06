#include<bits/stdc++.h>
using namespace std;
vector<int> v[100];
int leaf[100]={0},maxd=-1;
void dfs(int node,int dep) {
    if (v[node].size()==0) {
        leaf[dep]++;
        maxd = max(dep, maxd);
        return;
    }
    for (int i = 0; i < v[node].size(); i++) {
        dfs(v[node][i],dep+1);
    }
}

int main()
{
    int n, m;
    int id, k,c;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> id >> k;
        for (int j = 0; j < k; j++) {
            cin >> c;
            v[id].push_back(c);
        }
    }
    dfs(1,1);
    cout << leaf[1];
    for (int i = 2; i <= maxd; i++) {
        cout << " " << leaf[i];
    }
    return 0;
}