#include<bits/stdc++.h>
using namespace std;

int main()
{
    char s[] = { 'W','T','L' };
    double res=0.0,t;
    int r1, r2, r3;
    double temp1 = 0.0;
    for (int i = 0; i < 3; i++) {
        cin >> t;
        if (t > temp1) {
            temp1 = t;
            r1 = i;
        }
    }
    double temp2 = 0.0;
    for (int i = 0; i < 3; i++) {
        cin >> t;
        if (t > temp2) {
            temp2 = t;
            r2 = i;
        }
    }
    double temp3 = 0.0;
    for (int i = 0; i < 3; i++) {
        cin >> t;
        if (t > temp3) {
            temp3 = t;
            r3 = i;
        }
    }
    cout << s[r1] << " " << s[r2] << " " << s[r3];
    printf(" %.2f", (temp1*temp2*temp3*0.65-1)*2);
    return 0;
}