#include<bits/stdc++.h>
using namespace std;
int month[13]={0,31,29,31,30,31,30,31,31,30,31,30,31};
bool isLunar(int year)  //�ж��Ƿ�������
{
    if(year%400==0||(year%4==0&&year%100!=0))
        return true;
    return false;
}
int y=2000,m=1,d=1,w=6;
int sum;
int main()
{
    for (int i = 1; i <= 10000; i++) //1000���൱��1000��ѭ��
    {
        if(y==2020&&m==10&&d==1)
        {
            cout<<sum+2;
            return 0;
        }
        if(w==1||d==1)
            sum+=2;
        else
            sum+=1;
        d++;
        w++;
        if(w>=8)
            w=1;
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
    return 0;
}
