#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>
#include <cstring>

using namespace std;

struct People
{
    char name[120];
    int year=0;
};
bool cmp(People a, People b)
{
    return  a.year >  b.year;
}
int main()
{
    int t;
    cin >> t;
    char str[120];
    for (int i = 0; i < t; i++)
    {
        int n;
        scanf("%d",&n);
        getchar();
        People* p = new People[n];
        for (int j = 0; j < n; j++)
        {
            gets(str);
            int len = strlen(str);
            for (int k = len - 4; k < len; k++)
                p[j].year = 10 * p[j].year + str[k] - '0';
            for(int k=0;k<len-5;k++)
                p[j].name[k]=str[k];
            p[j].name[len-5]='\0';
        }
        sort(p, p + n, cmp);
        for (int k = 0; k < n; k++)
            cout << p[k].name << endl;
    }
    return 0;
}
