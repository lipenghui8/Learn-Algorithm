#include <bits/stdc++.h>

using namespace std;
#define MAXSIZE 1000

typedef int ElemType;
typedef int Status;
struct
{
    ElemType*elem;
    int length;
}SqList;
//菜单信息
void Menu()
{
    cout<<"1----初始化一个线性表"<<endl;
    cout<<"2----销毁线性表"<<endl;
    cout<<"3----清空线性表"<<endl;
    cout<<"4----判断线性表是否为空"<<endl;
    cout<<"5----求线性表长度"<<endl;
    cout<<"6----获取线性表制定位置元素"<<endl;
    cout<<"7----求前驱"<<endl;
    cout<<"8----求后继"<<endl;
    cout<<"9----在线性表指定位置插入元素"<<endl;
    cout<<"10---删除线性表指定位置元素"<<endl;
    cout<<"11---显示线性表"<<endl;
    cout<<"     退出，输入一个负数！"<<endl;
}
//初始化
Status InitList(SqList &L)
{
    L.elem=new ElemType[MAXSIZE];
    if(!L.elem) exit(0);
    L.length=0;
    return 1;
}
//取值
Status GetElem(SqList L,int i,ElemType &e)
{
    if(i<1||i>L.length) return 0;
    e=L.elem[i-1];
    return 1;
}
//查找 查找值为e的数据元素，返回其序号
int LocateElem(SqList L,ElemType e)
{
    for(int i=0;i<L.length;i++)
        if(L.elem[i]==e) return i+1;
    return 0;
}
//插入
Status ListInsert(SqList &L,int i,ElemType e)
{
    if(i<1||i>L.length+1) return 0;
    if(L.length==MAXSIZE) return 0;
    for(j=L.length-1;j>=i-1;j--)
        L.elem[j+1]=L.elem[j];
    L.elem[i-1]=e;
    ++L.length;
    return 1;
}
//求前驱
ElemType BeforeElem(ElemType L,int i)
{
    return L.elem[i-1];
}
//求后继
ElemType AfterElem(ElemType L,int i)
{
    return L.elem[i+1];
}
//删除
Status ListDelete(SqList &L,int i)
{
    if(i<1||i<L.length-1) return 0;
    for(j=i;j<=L.length-1;j++)
        L.elem[j-1]=L.elem[j];
    --L.length;
    return 1;
}
//销毁
Status ListDistory(SqList &L)
{
    if(L.elem) delete[] L.elem;
    L.length=0;
    L.elem=NULL;
    return 1;
}
//清空
void ClearList(SqList &L)
{
    L.length=0;
    return 1;
}
//求顺序表长度
int GetLength(SqList L)
{
    return L.length;
}
//判断顺序表是否为空
bool IsEmpty(SqlList L)
{
    if(L.length==0)
        return true;
    else
        return false;
}
//显示线性表
void PrintList(SqList L)
{
    for(int i=0;i<L.length;i++)
        cout<<L.elem[i]<<" ";
}
int main()
{
    int q,i;
    SqList L;
    ElemType e;
    while(cin>>q)
    {
        string msg;
        switch(q)
            {
                case 1:
                    msg=InitList(L);
                    break;
                case 2:
                    msg=ListDistory(L);
                    break;
                case 3:
                    msg=ClearList(L);
                    break;
                case 4:
                    IsEmpty(L);
                    break;
                case 5:
                    GetLength(L);
                    break;
                case 6:
                    cout<<"请输入要查找的值：";
                    cin>>e;
                    msg=GetElem(L,e);
                    break;
                case 7:
                    cout<<"请输入要查找的元素位置:";
                    cin>>i;
                    BeforeElem(L,i);
                    break;
                case 8:
                    cout<<"请输入要查找的元素位置:";
                    cin>>i;
                    BeforeElem(L,i);
                    break;
                case 9:
                    cout<<"请输入要插入的位置：";
                    cin>>i;
                    ListInsert(L,i);
                    break;
                case 10:
                    cout<<"请输入要删除的位置：";
                    cin>>i;
                    ListDelete(L,i);
                    break;
                case 11:
                    PrintList(L);
                    break;
            }
    }
    return 0;
}
