#include <iostream>

using namespace std;

void Joseph(int n,int m)
{
    int*a=new int[n];
    int p=0,k=1;
    for(int i=0;i<n;i++)
        a[i]=i+1;
    while(n>1)
    {
        p=(p+m-1)%n;
        cout<<"��"<<k++<<"�����е��ǣ�"<<a[p]<<endl;
        for(int i=p+1;i<n;i++)
            a[i-1]=a[i];
        n--;
    }
    cout<<"���ʣ�µ��ǣ�"<<a[p]<<endl;
}

int main()
{
    int m,n;
    cin>>n>>m;
    Joseph(n,m);
    return 0;
}
