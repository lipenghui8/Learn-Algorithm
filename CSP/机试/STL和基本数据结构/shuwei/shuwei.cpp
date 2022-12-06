#include<bits/stdc++.h>
using namespace std;
typedef long long LL;
int check(string s) {
    LL cnt = 0;
    sort(s.begin(), s.end());
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '1') {
            cnt++;
        }
        else if(s[i]>'1'){
            break;
        }
    }
    return cnt;
}
const int k = 100000;
LL s[k];
int main()
{
    for (int i = 1; i < k; i++) {
        s[i] = check(to_string(i))+s[i-1];
    }
    int t;
    cin >> t;
    while (t--) {
        LL x;
        cin >> x;
        cout<<lower_bound(s, s + k, x)-s<<endl;
    }
    return 0;
}