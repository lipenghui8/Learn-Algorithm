#include<bits/stdc++.h>
using namespace std;
int month[13]={0,31,28,31,30,31,30,31,31,30,31,30,31}; //2014�������꣬��ʼ2��Ϊ28��
bool isLunar(int year)  //�ж��Ƿ�������
{
    if(year%400==0||(year%4==0&&year%100!=0))
        return true;
    return false;
}
int y=2014,m=11,d=9;
int main()
{
    for (int i = 1; i <= 1000; i++) //1000���൱��1000��ѭ��
    {
        d++;
        if(d>month[m]) //����������ڵ�������
        {
            m++;    //�·�+1
            d=1;    //������1
            if(m>12)    //�����������12����������1��ݼ�һ
            {
                m=1;
                y++;
                if(isLunar(y))  //��ݼ�һ��ʱ���жϵ�ǰ����Ƿ�������
                    month[2]=29;
                else
                    month[2]=28;   //ע�ⲻ������Ҫ��2�»ָ���28��
            }
        }
    }
    cout<<y<<" "<<m<<" "<<d<<endl;
    return 0;
}
