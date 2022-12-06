#include <iostream>

using namespace std;

int main()
{
    char str[50];
    while(cin>>str)
    {
        int len=strlen(str);
        char*res=new char[len];
        if(len==1)
        {
            cout<<str<<endl;
            continue;
        }
        int i;
        if(len%2==0)
        {
            i=len-1;
            for(int j=0;2*j<len;i--,j++)
            {
                res[2*j]=str[i];
                res[2*j+1]=str[len-i-1];
            }
        }
        else{
            i=0;
            for(int j=0;j*2<len;i++,j++)
            {
                res[j*2]=str[i];
                res[j*2+1]=str[len-i-1];
            }
        }
        reverse(res,res+len);
        for(int i=0;i<len;i++)
            cout<<res[i];
        cout<<endl;
    }
    return 0;
}
