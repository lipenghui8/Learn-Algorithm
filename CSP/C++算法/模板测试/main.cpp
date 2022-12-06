#include <bits/stdc++.h>

using namespace std;

bool compare (char s1[ ], char s2[ ]) //判断两个数的大小
{
    int u=strlen(s1), v=strlen(s2);
    if(u!=v)
        return u>v;
    for(int i=0; i<u; i++)
        if(s1[i]!=s2[i])
            return s1[i]>s2[i];
    return true;
}
int main()
{
    char s1[]="125473825784375843785";
    char s2[]="79573485974389275";
    if(!compare(s1,s2))
    {
        int flag=1;
        string s3;
        strcpy(s3,s1);
        strcpy(s1,s2);
        strcpy(s2,s3);
    }
    //----输入----
    lenc=max(lena,lenb);
    for(int i=1; i<=lenc; i++)
    {
        If(a[i] < b[i])
        {
            a[i+1]--;
            a[i]+=10;
        }
        C[i]=a[i]-b[i];
    }
    //----消零输出----
    if(flag==1) cout<<"-";
}
