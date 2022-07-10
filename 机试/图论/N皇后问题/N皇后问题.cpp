#include<iostream>
using namespace std;
int n,sum=0;
int v[11],res[11];
int vz[50], vy[50];

void dfs(int x)
{
    if (x > n) {
        sum++;
        return;
    }
    for (int i = 1; i <= n; i++) {
        if (v[i] == 0 && vz[x + i]==0 && vy[x - i+n]==0) {
            v[i] = 1;
            vz[x + i] = 1;
            vy[x - i + n] = 1;
            dfs(x + 1);
            v[i] = 0;
            vz[x + i] = 0;
            vy[x - i + n] = 0;
        }
    }
}
int main()
{
    for (int i = 1; i <= 10; i++) {
        memset(v, 0, sizeof(v));
        memset(vz, 0, sizeof(vz));
        memset(vy, 0, sizeof(vy));
        sum = 0;
        n = i;
        dfs(1);
        res[i] = sum;
    }
    while (cin >> n&&n!=0) {
        cout << res[n] << endl;
    }
    return 0;
}