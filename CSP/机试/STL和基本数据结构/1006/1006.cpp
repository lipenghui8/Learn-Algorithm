#include<bits/stdc++.h>
using namespace std;

int main()
{
    int m;
    cin >> m;
    string s,res1,res2,t1,t2;
    int mh1=99, mm1=99, ms1=99, mh2=0, mm2=0, ms2=0;
    int h1, m1, s1,h2,m2,s2;
    for (int i = 0; i < m; i++) {
        cin >> s;
        scanf("%d:%d:%d %d:%d:%d", &h1, &m1, &s1, &h2, &m2, &s2);
        int flag = 0;
        if (h1 < mh1) {
            flag = 1;
        }
        else if (h1 == mh1) {
            if (m1 < mm1) {
                flag = 1;
            }
            else if (m1 == mm1) {
                if (s1 < ms1) {
                    flag = 1;
                }
            }
        }
        if (flag == 1) {
            mh1 = h1;
            mm1 = m1;
            ms1 = s1;
            res1 = s;
        }
        flag = 0;
        if (h2 < mh2) {
            flag = 1;
        }
        else if (h2 == mh2) {
            if (m2 < mm2) {
                flag = 1;
            }
            else if (m2 == mm2) {
                if (s2 < ms2) {
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            mh2 = h2;
            mm2 = m2;
            ms2 = s2;
            res2 = s;
        }
    }
    cout << res1 << " " << res2;
    return 0;
}