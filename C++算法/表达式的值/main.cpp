#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int main()
{
    int a,b;
    string s="";
    stack<int> st;
    cin>>a>>b;
    cin>>s;
    for(int i=0;i<s.size();i++){
        int num=0;
        int flag=1;
        if((s[i]>='0'&&s[i]<='9')||s[i]=='-'){
            while((s[i]>='0'&&s[i]<='9')||s[i]=='-'){
                if(s[i]=='-'){
                    flag=-1;
                }else{
                    num=num*10+(s[i]-'0');
                }
                i++;
            }
            st.push(num*flag);
        }
        if(s[i]==')'){
            int n1=st.top();
            st.pop();
            int n2=st.top();
            st.pop();
            st.push(n1*b+n2*a);
        }
    }
    cout<<st.top();
    return 0;
}
