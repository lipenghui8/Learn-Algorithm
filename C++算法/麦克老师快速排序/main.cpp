#include <iostream>

using namespace std;
int a[101],n;//定义全局变量
void quicksort(int left,int right)
{
    int i,j,t,temp;
    if(left>right)
        return;
    temp=a[left];//存放基准数
    i=left;
    j=right;
    while(i!=j)
    {
        while(a[j]>=temp&&i<j)//先从右往左找
            j--;
        while(a[i]<=temp&&i<j)//再从左往右找
            i++;
        //交换两个数在数组中的位置
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
