#include <iostream>
#include <cmath>

using namespace std;
#define MAXSIZE 100
typedef int SElemType;
typedef struct{
    SElemType *base;
    SElemType *top;
    int stacksize;
}SqStack;

//初始化栈
int InitStack(SqStack&S)
{
    S.base=new SElemType[MAXSIZE];
    S.top=S.base;
    S.stacksize=MAXSIZE;
    return 1;
}
//判断栈是否为空
bool StackEmpty(SqStack S)
{
    if(S.top==S.base) return true;
    else return false;
}
//求顺序栈的长度
int StackLength(SqStack S)
{
    return S.top-S.base;
}
//清空顺序栈
int ClearStack(SqStack &S)
{
    if(S.base) S.top=S.base;
    return 1;
}
//销毁顺序栈
int DestroyStack(SqStack &S)
{
    if(S.base)
    {
        delete[]S.base;
        S.stacksize=0;
        S.base=S.top=NULL;
    }
    return 1;
}
//入栈
int Push(SqStack &S,SElemType e)
{
    if(S.top-S.base==S.stacksize)
        return 0;
    *S.top++=e;
    return 1;
}
//出栈
int Pop(SqStack &S,SElemType&e)
{
    if(S.top==S.base)
        return 0;
    e=*--S.top;
    return 1;
}
//取栈顶元素
int GetTop(SqStack S,SElemType&e)
{
    if(S.top==S.base) return 0;
    e=*(S.top-1);
    return 1;
}
//输出栈内元素
void print(SqStack S)
{
    while(S.top!=S.base)
    {
        cout<<*(S.top-1);
        S.top--;
    }
}
//创建并输入栈元素
void BulidStack(SqStack &S,int n)
{
    while(n--)
    {
        cin>>*S.top;
        S.top++;
    }
}
//输出提示信息
void welcome()
{
    cout<<"****************"<<endl;
    cout<<"1.初始化为空栈"<<endl;
    cout<<"2.销毁栈"<<endl;
    cout<<"3.将栈置空"<<endl;
    cout<<"4.判断栈是否为空栈"<<endl;
    cout<<"5.返回栈的长度"<<endl;
    cout<<"6.求栈顶元素"<<endl;
    cout<<"7.插入元素，并使其成为栈顶元素"<<endl;
    cout<<"8.删除栈顶元素，并返回其值"<<endl;
    cout<<"9.输出栈内元素"<<endl;
    cout<<"10.创建并输入栈元素"<<endl;
    cout<<"11.退出"<<endl;
    cout<<"12.运行数字转换程序"<<endl;
    cout<<"****************"<<endl;
}
bool IsLegal(SqStack S)
{
    if(abs(S.top-S.base)>MAXSIZE)
        return false;
    else if(!S.base)
        return false;
    else
        return true;
}
int main()
{
    SqStack S;
    SElemType e;
    int n,mes;
//    cout<<*S.top<<" "<<*S.base;
//    return 0;
    welcome();
    cout<<"请输入你的选择>>";
    while(cin>>n)
    {
        switch(n)
        {
        case 1:
            mes=InitStack(S);
            if(mes)
                cout<<"初始化成功！"<<endl;
            break;
        case 2:
            if(!IsLegal(S)){
                cout<<"栈未初始化！"<<endl;
                break;
            }
            mes=DestroyStack(S);
            if(mes)
                cout<<"销毁成功！"<<endl;
            break;
        case 3:
            if(!IsLegal(S)){
                cout<<"栈未初始化！"<<endl;
                break;
            }
            mes=ClearStack(S);
            if(mes)
                cout<<"栈已置空！"<<endl;
            break;
        case 4:
            if(!IsLegal(S)){
                cout<<"栈未初始化！"<<endl;
                break;
            }
            if(StackEmpty(S))
                cout<<"栈为空！"<<endl;
            else
                cout<<"非空！"<<endl;
            break;
        case 5:
            if(!IsLegal(S)){
                cout<<"栈未初始化！"<<endl;
                break;
            }
            mes=StackLength(S);
            cout<<"栈的长度为："<<mes<<endl;
            break;
        case 6:
            if(!IsLegal(S)){
                cout<<"栈未初始化！"<<endl;
                break;
            }
            mes=GetTop(S,e);
            if(mes)
                cout<<"栈顶元素为："<<e<<endl;
            else
                cout<<"操作失败！"<<endl;
            break;
        case 7:
            if(!IsLegal(S)){
                cout<<"栈未初始化！"<<endl;
                break;
            }
            cout<<"请输入一个元素：";
            cin>>e;
            mes=Push(S,e);
            if(mes)
                cout<<"入栈成功！"<<endl;
            else
                cout<<"操作失败！"<<endl;
            break;
        case 8:
            if(!IsLegal(S)){
                cout<<"栈未初始化！"<<endl;
                break;
            }
            mes=Pop(S,e);
            if(mes)
                cout<<"栈顶元素为："<<e<<endl;
            else
                cout<<"操作失败！"<<endl;
            break;
        case 9:
            if(!IsLegal(S)){
                cout<<"栈未初始化！"<<endl;
                break;
            }
            print(S);
            cout<<endl;
            break;
        case 10:
            cout<<"请输入要初始化的元素个数：";
            cin>>mes;
            cout<<"请输入"<<mes<<"个元素："<<endl;
            BulidStack(S,mes);
            break;
        case 11:
            return 0;
            break;
        case 12:
            cout<<"请输入要转换的数字：";
            cin>>e;
            InitStack(S);
            while(e)
            {
                Push(S,e%2);
                e/=2;
            }
            print(S);
            cout<<endl;
            break;
        default:
            cout<<"操作有误！"<<endl;
        }
        cout<<"请输入你的选择>>";
    }
    return 0;
}
