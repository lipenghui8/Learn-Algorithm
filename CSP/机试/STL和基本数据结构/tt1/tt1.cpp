#include<bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    scanf("%d", &t);
    while (t--) {
        stack<int> s;
        int n, cnt = 0, a=0;
        scanf("%d", &n);
        for (int i = 0; i < n; i++) {
            scanf("%d", &a);
            if(!s.empty()){
                while (!s.empty()&&s.top()>= a) {
                    s.pop();
                }
            }
            s.push(a);
            if ( s.size() > cnt) {
                cnt = s.size();
            }
        }
        printf("%d\n", cnt);
    }
    return 0;
}