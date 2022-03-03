#include<bits/stdc++.h>
using namespace std;
int month[13]={0,31,28,31,30,31,30,31,31,30,31,30,31}; //2014不是闰年，初始2月为28天
bool isLunar(int year)  //判断是否是闰年
{
    if(year%400==0||(year%4==0&&year%100!=0))
        return true;
    return false;
}
int y=2014,m=11,d=9;
int main()
{
    for (int i = 1; i <= 1000; i++) //1000天相当于1000次循环
    {
        d++;
        if(d>month[m]) //如果天数大于当月天数
        {
            m++;    //月份+1
            d=1;    //天数置1
            if(m>12)    //如果月数大于12，将月数置1年份加一
            {
                m=1;
                y++;
                if(isLunar(y))  //年份加一的时候判断当前年份是否是闰年
                    month[2]=29;
                else
                    month[2]=28;   //注意不是闰年要把2月恢复成28天
            }
        }
    }
    cout<<y<<" "<<m<<" "<<d<<endl;
    return 0;
}
