#include <iostream>

using namespace std;

const int INF=0x3f3f3f;
int main()
{
    int n;
    int sum=0,maxn=-INF,minn=INF,sumn=0.0;
    while(cin>>n)
    {
        if(n<0)
        {
            cout<<"�ܺ�="<<sum<<"�� ƽ��ֵ="<<sum/sumn<<"�� ���ֵ="<<maxn<<"�� ��Сֵ="<<minn<<endl;
            break;
        }
        if(n>maxn)
            maxn=n;
        if(n<minn)
            minn=n;
        sum+=n;
        sumn++;
    }
    return 0;
}
