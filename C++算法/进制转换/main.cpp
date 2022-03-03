#include <bits/stdc++.h>

using namespace std;

int main()
{
//    int n;
//    scanf("%d",&n);
//    printf("%x\n",n);
//    cout<<bitset<8>(n)<<endl;
    printf("%ld\n",strtol("16",NULL,8));//8进制转换为十进制
    char str[100];
    itoa(65,str,2);
    printf("%s",str);
    return 0;
}
