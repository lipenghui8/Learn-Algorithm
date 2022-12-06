#include<bits/stdc++.h>
using namespace std;

int main()
{
    float s[1001] = { 0 };
    int k, n;
    float a;
    cin >> k;
    for (int i = 0; i < k; i++) {
        cin >> n >> a;
        s[n] += a;
    }
    cin >> k;
    for (int i = 0; i < k; i++) {
        cin >> n >> a;
        s[n] += a;
    }
    int cnt = 0;
    for (int i = 0; i < 1001; i++) {
        if (s[i] != 0)cnt++;
    }
    printf("%d", cnt);
    for (int i = 1000; i >=0; i--) {
        if (s[i] != 0.0) {
            printf(" %d %.1f", i, s[i]);
        }
    }
    return 0;
}