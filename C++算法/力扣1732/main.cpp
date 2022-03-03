#include <iostream>
#include <vector>
using namespace std;
int pivotIndex(int nums[],int n) {
        cout<<sizeof(nums)<<endl;
        for(int i=0;i<n;i++)
        {
            int left=0,right=0;
            for(int j=0;j<i;j++)
                left+=nums[j];
            for(int j=i+1;j<n;j++)
                right+=nums[j];
            cout<<left<<" "<<right<<" "<<n<<endl;
            if(left==right)
                return i;
        }
        return -1;
    }
int main()
{
    int a[742]={44,32,-9,52,23,-50};
    cout<<pivotIndex(a,sizeof(a)/sizeof(a[0]));
    return 0;
}
