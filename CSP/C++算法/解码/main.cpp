#include <bits/stdc++.h>

using namespace std;

int main()
{
    string a;
    cin>>a;
    for(int i=0;i<a.length();i++)
    {
        char k=a[i];
        if((i==a.length()-1)&&((k>='A'&&k<='Z')||(k>='a'&&k<='z')))
        {
            cout<<k;
            break;
        }
        char p=a[i+1];
        if(((k>='A'&&k<='Z')||(k>='a'&&k<='z'))&&((p>='0')&&p<='9'))
        {
            int j=a[i+1]-'0';
            for(int m=0;m<j;m++)
                cout<<k;
                i++;
                continue;
        }
        else if(((k>='A'&&k<='Z')||(k>='a'&&k<='z'))&&((p>='A'&&p<='Z')||(p>='a'&&p<='z')))
            cout<<k;

    }
    return 0;
}
