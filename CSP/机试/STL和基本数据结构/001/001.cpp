#include<bits/stdc++.h>
using namespace std;

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

int main()
{
    int a, b, c, d, e, f;
    cin >> a >> b >> c >> d >> e >> f;
    if (b == 0 && e == 0) {
        cout << a + d << " 0 0";
    }
    else {
        int p = a + d;
        int q = b * f + e * c;
        int r = c * f;
        int k = gcd(q, r);
        q = q / k;
        r = r / k;
        if (q >= r) {
            p += q / r;
            q = q % r;
        }
        if (r == 1) {
            r = 0;
        }
        cout << p << " " << q << " " << r;
    }
    return 0;
}