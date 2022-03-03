#include <bits/stdc++.h>

using namespace std;

int main()
{
    long long n;
    scanf("%lld",&n);
    printf("%lld",n);
    while(n/2>0)
    {
        n=n/2;
        printf(" %lld",n);
    }
    return 0;
}
