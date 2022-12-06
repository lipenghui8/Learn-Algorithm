#include<bits/stdc++.h>
using namespace std;
long long s[501][501];
int main()
{
    int n, m,p;
    long long r,sum=0,res=0;
    cin >> n >> m >> r;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> p;
            s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1]+p;
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            for (int k = i; k <= n; k++) {
                for (int q = j; q <= m; q++) {
                    sum = s[k][q] - s[k][j - 1] - s[i - 1][q] + s[i - 1][j - 1];
                    if (sum <= r) {
                        res++;
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }
    cout << res;
    return 0;
}