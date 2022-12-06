#include <iostream>
using namespace std;

int months[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

// 判断日期的合法性
bool check_valid(int date) //形如20210305
{
    int year = date / 10000;
    int month = date % 10000 / 100;
    int day = date % 100;

    if (month <= 0 || month >= 13) return false;
    if (day == 0 || month != 2 && day > months[month]) return false;

    if (month == 2)
    {
        int leap = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
        if (day > 28 + leap) return false;
    }

    return true;
}

// 得到某年某月的天数
int get(int year, int month)
{
    if (month != 2) return months[month];
    else
    {
        // 2月
        int leap = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
        return 28 + leap;
    }
}

// 判断两个日期之间有多少个回文日期
int get(int date1, int date2, int k) //k使函数签名不同从而编译通过
{
    int ans = 0;
    for (int i = 1000; i < 10000; i++)
    {
        int date = i, x = i;
        for (int j = 0; j < 4; j++) date = date * 10 + x % 10, x /= 10; //根据年份构造出回文日期
        if (date1 <= date && date <= date2 && check_valid(date)) ans++;
    }

    return ans;
}

// 给定年月日，经过n天后对应的日期
void pass(int y, int m, int d, int n)
{
    while (n--)
    {
        d++;
        if (d > get(y, m)) m++, d = 1;
        if (m > 12) y++, m = 1;
    }
    printf("%d-%02d-%02d\n", y, m, d);
}

int main()
{
    return 0;
}
