#include <bits/stdc++.h>

using namespace std;

#define maxn 100
int tree[maxn][30];
int tot;
void insert_(char*str)
{
    int len=strlen(str);
    int root=0;
    for(int i=0;i<len;i++)
    {
        int id=str[i]-'a';
        if(!tree[root][id]) tree[root][id]=++tot;
        root=tree[root][id];
    }
}
int find_(char*str)
{
    int len=strlen(str);
    int root=0;
    for(int i=0;i<len;i++)
    {
        int id=str[i]-'a';
        if(!tree[root][id]) return 0;
        root=tree[root][id];
    }
    return root;
}
int main()
{
    char a[][30]={"fdsafsa","ewrfet","fewqr","ewqrut","ewrqhg","gdfsrh"};
    for(int i=0;i<6;i++)
    {
        insert_(a[i]);
    }
    for(int i=0;i<6;i++)
    {
        for(int j=0;j<10;j++)
            cout<<tree[i][j]<<"\t";
        cout<<endl;
    }
    cout<<tot<<"----"<<endl;

    return 0;
}
