#include<iostream>
#include<cstring>
#include<algorithm>
#include<cstdio>
#define N 5
using namespace std;

int days[13] = {0,31,28,31,30,31,30,31,31,30,31,30,31};

int check_vaild(int n)
{
    int year = n / 10000 , month = n % 10000 / 100 , day = n % 100;

    if(month < 0 || month > 12)   return false;

    if(day < 0 || (day > days[month] && month != 2))    return false;

    int x = 0;
    if(month == 2)
        x = year % 4 == 0 && year % 100 || year % 400 == 0;
    if(day > days[month] + x)   return false;

    return true;
}

int check_ABAB(int n)
{
    int a = n / 10000000 , b = n / 1000000 % 10 , c = n /100000 % 10 , d = n / 10000 % 10;
    if(a == c && b == d && a != b)  return true;
    return false;
}

int main()
{
    int n;
    scanf("%d",&n);

    int falg = 1;
    for(int i = n / 10000;i < 100000;i ++)
    {
        int x = i , t = i;
        for(int j = 0;j < 4;j ++)
            x = x*10 + t%10 , t /= 10;
        if(check_vaild(x) && x > n && falg)
        {
            printf("%d\n",x);
            falg = 0;
        }
        if(check_vaild(x) && check_ABAB(x) && x > n)
        {
            printf("%d\n",x);
            break;
        }
    }
    return 0;
}
