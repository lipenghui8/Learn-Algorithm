#include<iostream>
#include<vector>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int k;
    while (n--) {
        cin >> k;
        vector<int> s;
        for (int i = 1; i <= k; i++) {
            s.push_back(i);
        }
        int flag = 1;
        while (s.size() > 3) {
            if (flag) {
                int i = 1;
                for (vector<int>::iterator it=s.begin(); it != s.end();i++) {
                    if (i % 2 == 0) {
                        it=s.erase(it);
                    }
                    else {
                        it++;
                    }
                }
                flag = 0;
            }
            else {
                int i = 1;
                for (vector<int>::iterator it = s.begin(); it != s.end();i++) {
                    if (i % 3 == 0) {
                        it = s.erase(it);
                    }
                    else {
                        it++;
                    }
                }
                flag = 1;
            }
        }
        for (int i = 0; i < s.size()-1; i++) {
            cout<<s[i]<<" ";
        }
        cout <<s[s.size()-1]<< endl;
    }
    return 0;
}