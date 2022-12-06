#include <iostream>

using namespace std;
#define MAXSIZE 100;
typedef int SElemType;
typedef struct{
    SElemType data;
    SElemType *next;
}StackNode,*LinkStack;
//初始化链栈
void InitStack(LinkStack&S)
{
    S=NULL;
}
//判断链栈是否为空
bool StackEmpty(LinkStack S)
{
    if(S==NULL) return 1;
    else return 0;
}
//链栈进栈
int Push(LinkStack &S,SElemType e)
{
    p=new StackNode;
    p->data=e;
    p->next=S;
    S=p;
    return 1;
}
//链栈出栈
int Pop(LinkStack &S,SElemType&e)
{
    if(S==NULL) return 0;
    e=S->data;
    p=S;
    S=S->next;
    delete p;
    return 1;
}
//输出提示信息
void welcome()
{
    cout<<"****************"<<endl;
    cout<<"请输入指令："<<endl;
    cout<<"****************"<<endl;
}
int main()
{
    StackNode S;
    SElemType e;
    welcome();

    return 0;
}
