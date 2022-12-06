#include <bits/stdc++.h>

using namespace std;
stack<int> s;
int main()
{
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        int p,q;
        cin>>p;
        if(p==1){
            cin>>q;
            s.push(q);
        }else if(p==2){
            cout<<s.top()<<endl;
            s.pop();
        }
    }
    return 0;
}
