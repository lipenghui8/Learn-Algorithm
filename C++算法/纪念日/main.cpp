#include <iostream>

using namespace std;

int yearDay(int a)
{
    if(a%4==0&&a%100!=0||a%400==0)
        return 366;
    else
        return 365;
}
int main()
{
    int sum=0;
    for(int i=1922;i<=2020;i++)
    {
        sum+=yearDay(i);
    }
    cout<<(sum-22)*24*60;
    return 0;
}
