#include <iostream>

using namespace std;
int a[101],n;//����ȫ�ֱ���
void quicksort(int left,int right)
{
    int i,j,t,temp;
    if(left>right)
        return;
    temp=a[left];//��Ż�׼��
    i=left;
    j=right;
    while(i!=j)
    {
        while(a[j]>=temp&&i<j)//�ȴ���������
            j--;
        while(a[i]<=temp&&i<j)//�ٴ���������
            i++;
        //�����������������е�λ��
        if(i<j)
        {
            t=a[i];
            a[i]=a[j];
            a[j]=t;
        }
    }
    a[left]=a[i];
    a[i]=temp;

    quicksort(left,i-1);
    quicksort(i+1,right);
    return;
}
int main()
{
    cin>>n;
    for(int i=1;i<=n;i++)
    {
        cin>>a[i];
    }
    quicksort(1,n);
    for(int i=1;i<=n;i++)
        cout<<a[i]<<" ";
    return 0;
}
