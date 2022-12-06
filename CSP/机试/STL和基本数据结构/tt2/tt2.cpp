#include<bits/stdc++.h>
using namespace std;
int s[51][51];
inline int check(int a, int b) {
    if (a > 5) {
        return -1;
    }
    else if (a < 5) {
        return 0;
    }
    else if(a==5){
        return b;
    }
}
int main()
{
    int t;
    cin >> t;
    while (t--) {
        int n, m, k;
        memset(s, 0, sizeof(s));
        cin >> n >> m >> k;
        int x, y;
        for (int i = 0; i < k; i++) {
            cin >> x >> y;
            s[x][y] = 1;
        }
        for (int i = 0; i < k; i++) {
            cin >> x >> y;
            s[x][y] = 2;
        }
        int f1 = 0, f2 = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s[i][j] != 0) {
                    int k = s[i][j];
                    int ll = max(0, j - 4),rr=ll;
                    for (rr; rr <= j + 4 && rr <= m; ) {
                        if (s[i][rr] == s[i][rr - 1]) {
                            rr += 1;
                        }
                        else {
                            ll = rr;
                        }
                    }
                    if (check(rr - ll, s[i][j]) == -1) {
                        cout << "N" << endl;
                    }
                }
            }
        }
        cout << "N" << endl;
    }
    return 0;
}