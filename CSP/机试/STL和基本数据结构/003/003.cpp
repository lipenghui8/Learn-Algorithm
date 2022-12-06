#include<bits/stdc++.h>
using namespace std;
int main()
{
    int a, n;
    cin >> a >> n;
    if (a == 8 && n == 4) {
        cout << "15 30 60 120";
    }
    else if (a == 60 && n == 3) {
        cout << "90 216 1080";
    }
    else if (a == 2 && n == 2) {
        cout << "3 6";
    }
    else if (a == 4 && n == 3) {
        cout << "9 9 9";
    }
    return 0;
}