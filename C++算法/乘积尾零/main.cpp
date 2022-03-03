#include <bits/stdc++.h>

using namespace std;
int main()
{
    int sum2=0,sum5=0,res=1,n;
    for(int i=0;i<100;i++)
    {
        scanf("%d",&n);
        while(1)
        {
            if(n%5==0)
            {
                sum5++;
                n/=5;
            }
            else if(n%2==0)
            {
                sum2++;
                n/=2;
            }
            else
                break;
        }
    }
    cout<<min(sum2,sum5);
    return 0;
}
