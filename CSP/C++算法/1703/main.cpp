#include <bits/stdc++.h>

using namespace std;

struct stu{
    string name;
    int sc;
};
bool cmp(stu a,stu b)
{
    return a.sc>b.sc;
}
int main()
{
    int N,M,G;
    while(cin>>N)
    {
        if(N==0)
            return 0;
        cin>>M>>G;
        int*sc=new int[M];
        for(int i=0;i<M;i++)
            cin>>sc[i];
        stu*t=new stu[N];
        int sum=0;
        for(int i=0;i<N;i++)
        {
            string name;
            int tsc=0,n,s;
            cin>>name>>n;
            for(int i=0;i<n;i++)
            {
                cin>>s;
                tsc+=sc[s-1];
            }
            t[i].name=name;
            t[i].sc=tsc;
            if(tsc>=G)
                sum++;
        }
        sort(t,t+N,cmp);
        cout<<sum<<endl;
        for(int i=0;i<sum;i++)
        {
            cout<<t[i].name<<" "<<t[i].sc<<endl;
        }
    }
    return 0;
}
