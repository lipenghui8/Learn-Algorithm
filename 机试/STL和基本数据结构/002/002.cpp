#include<bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}
int main()
{
    int a1, a2, b1, b2, d1, d2;
    cin >> a1 >> a2 >> b1 >> b2 >> d1 >> d2;
    int q = a2 * b2 * d2;
    int p = a1 * b2 * d2 + b1 * a2 * d2 + d1 * a2 * b2;
    p = q - p;
    int r = gcd(p, q);
    cout << p / r << " " << q / r;
    return 0;
}