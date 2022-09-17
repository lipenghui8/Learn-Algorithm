#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    int s[10001] = { 0 };
    cin >> n;
    int res = -1,temp=0,left=0,right=n-1,tindex=0;
    for (int i = 0; i < n; i++) {
        cin >> s[i];
        temp += s[i];
        if (temp > res) {
            res = temp;
            left = tindex;
            right = i;
        }
        else if(temp<0){
            temp = 0;
            tindex = i + 1;
        }
    }
    if (res < 0) res = 0;
    cout << res << " " << s[left] << " " << s[right];
    return 0;
}