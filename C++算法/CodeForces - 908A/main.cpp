#include <bits/stdc++.h>

using namespace std;

bool cmp(char a)
{
    return a=='a'||a=='e'||a=='i'||a=='o'||a=='u';
}
int main()
{
    char str[50];
    while(cin>>str)
    {
        int len=strlen(str),sum=0;
        for(int i=0;i<len;i++)
        {
            if(isdigit(str[i])&&(str[i]-'0')%2==1||cmp(str[i]))
            {
                sum++;
            }
        }
        cout<<sum<<endl;
    }
    return 0;
}
