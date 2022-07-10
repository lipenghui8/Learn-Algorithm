#include<bits/stdc++.h>
using namespace std;

int main()
{
    string s;
    int k;
    cin >> s >> k;
    int charcnt[26];
    memset(charcnt, 0, sizeof(charcnt));
    int maxcnt = 0;
    int len = s.length();
    int left = 0, right = 0;
    while (right < len) {
        charcnt[s[right] - 'A']++;
        maxcnt = max(maxcnt, charcnt[s[right] - 'A']);
        right++;

        if (right - left > maxcnt + k) {
            charcnt[s[left]-'A']--;
            left++;
        }
    }
    cout<<right - left;

    return 0;
}