#include <iostream>
#include <math.h>
using namespace std;

int main()
{
    double price=10000;
    double area=120;
    double shoufu=0.3;
    double year=30;
    double lv=0.0325;
    double sum=price*area;
    double zonghuan=sum*shoufu+(sum-sum*shoufu)*pow(1+lv,year);
    cout<<"���ܼ�:"<<sum<<endl;
    cout<<"�ܻ����:"<<zonghuan<<endl;
    cout<<"�¹�:"<<(zonghuan-sum*shoufu)/year<<endl;
    cout<<pow(1.05,year)<<endl;
    return 0;
}
