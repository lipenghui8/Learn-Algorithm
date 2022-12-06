#include<bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    scanf("%d", &t);
    while (t--) {
        int n, k, l, r, x,res=0,cnt=0,f=0;
        scanf("%d%d", &n, &k);
        while (k--) {
            scanf("%d%d%d", &l, &r,&x);
            res = max(res, x);
            if (l == r) {
                cnt += x;
            }
            else {
                f = 1;
            }
        }
        if (f == 1) {
            cout << res << endl;
        }
        else {
            cout << cnt << endl;
        }
    }
    return 0;
}