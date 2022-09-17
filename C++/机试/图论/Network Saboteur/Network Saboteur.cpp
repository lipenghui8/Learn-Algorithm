#include<iostream>
using namespace std;
int n;
int s[21][21],v[21];
int res[21];
int maxr;
void dfs(int x,int flag) {
    if (x > n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (v[i] == 0) {
                for (int j = 1; j <= n; j++) {
                    if (v[j] == 1) {
                        sum += s[i][j];
                    }
                }
            }
        }
        if (sum > maxr) {
            maxr = sum;
        }
        return;
    }
    v[x + 1] = 0;
    dfs(x + 1, 0);
    v[x + 1] = 1;
    dfs(x + 1, 1);
}
int main()
{
    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> s[i][j];
        }
    }
    v[1] = 0;
    dfs(1,0);
    cout << maxr<<endl;
    return 0;
}