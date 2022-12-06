#include<bits/stdc++.h>
using namespace std;

int main()
{
    string s;
    string arr[10] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    cin >> s;
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
        sum += s[i] - '0';
    }
    s = to_string(sum);
    cout << arr[s[0] - '0'];
    for (int i = 1; i < s.length(); i++) {
        cout <<" "<< arr[s[i] - '0'];
    }
    return 0;
}