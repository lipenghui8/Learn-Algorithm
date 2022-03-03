#include <iostream>

using namespace std;
string maximumTime(string time) {
    cout<<time[0]<<endl;
        if(time[0]=='?')
        {
            time[0]='2';
        }
        if(time[1]=='?')
        {
            if(time[0]=='0'||time[0]=='1')
                time[1]='9';
            else
                time[1]='3';
        }
        if(time[3]=='?')
            time[3]='5';
        if(time[4]=='?')
            time[4]='9';
        return time;
    }
int main()
{
    string a="0?:3?";
    cout<<maximumTime(a)<<endl;
    return 0;
}
