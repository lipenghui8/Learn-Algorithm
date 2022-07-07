#include <iostream>

using namespace std;

int main()
{
    string s,res="";
    cin>>s;
    char p;
    int flag=0;
    for(int i=0;i<s.size();i++){
        if(s[i]=='a'&&flag==0){
            res+=s[i];
            flag=1;
        }else if(s[i]!='a'){
            res+=s[i];
            flag=0;
        }
    }
    cout<<res;
    return 0;
}
