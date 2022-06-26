#include <iostream>

using namespace std;

int main()
{
    for(int i=1000;i<2000;i++){
        int j=i%10*1000+i%100/10*100+i%1000/100*10+i/1000;
        if(i*9==j){
            cout<<i<<endl;
        }
    }
    return 0;
}
