#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
using namespace std;
struct patient
{
    int id, p;
};
bool cmp(patient a, patient b) {
    if (a.p != b.p) {
        return a.p>b.p;
    }
    else if (a.p == b.p) {
        return a.id < b.id;
    }
}
int main()
{
    int n;
    string k;
    while (cin >> n) {
        vector<patient> d[4];
        int p=1;
        while(n--){
            cin >> k;
            if (k == "IN") {
                int a, b;
                cin >> a >> b;
                d[a].push_back({p,b});
                p++;
            }
            else if (k == "OUT") {
                int a;
                cin >> a;
                if (d[a].empty()) {
                    cout << "EMPTY" << endl;
                    continue;
                }
                sort(d[a].begin(), d[a].end(),cmp);
                cout << d[a].front().id << endl;;
                d[a].erase(d[a].begin());
            }
        }
    }
    return 0;
}