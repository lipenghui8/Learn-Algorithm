#include<bits/stdc++.h>
using namespace std;
typedef long long LL;

int main()
{
    string s;
    getline(cin, s);
    LL res = 0;
    for (LL i = 0; i < s.length(); i++) {
        if (s[i] != ' ' && s[i] != '\n') {
            res++;
        }
    }
    cout << res << endl;
    return 0;
}