#include<bits/stdc++.h>
using namespace std;

int main()
{
    int a, b;
    cin >> a >> b;
    string s = to_string(a + b);
    int ll = s.length();
    for (int i = ll-1; i--; i >= 0) {
        if (s[i] != '-'&&(ll - i) % 3 == 1) {
            s.insert(i + 1, ",");
        }
    }
    cout << s;
    return 0;
}