#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n,a=0,b=0;
    long long sum = 0;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a;
        if (a > b) {
            sum += (a - b) * 6 + 5;
        }
        else if (a < b) {
            sum += (b - a) * 4 + 5;
        }
        else if (a == b) {
            sum += 5;
        }
        b = a;
    }
    cout << sum;
    return 0;
}