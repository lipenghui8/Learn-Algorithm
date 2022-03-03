#include <bits/stdc++.h>

using namespace std;

struct change
{
    char x,y;
};
int main()
{
    int T;
    cin>>T;
    int ca=1;
    while(T--)
    {
        char a[1000],b[1000];
        cin>>a>>b;
        int n;
        cin>>n;
        change*ch=new change[n];
        for(int i=0;i<n;i++)
            cin>>ch[i].x>>ch[i].y;
        int lena=strlen(a),lenb=strlen(b);
        int kk=0;
        memset(a,0,sizeof(a));
        memset(b,0,sizeof(b));
        for(int i=0,j=0;j<lenb&&i<lena;i++,j++)
        {
            if(i==lena-1&&j<=lenb-1&&a[i]==b[j])
            {
                kk=1;
                break;
            }
            else if(a[i]==b[j])
                continue;
            int po=0;
            for(int k=0;k<n;k++)
                if(ch[k].x==b[j]&&ch[k].y==a[i])
                    po=1;
            if(po==1)
                continue;
            i--;
        }
        string res;
        kk==1?res="happy":res="unhappy";
        cout<<"Case #"<<ca++<<": "<<res<<endl;
    }
    return 0;
}
