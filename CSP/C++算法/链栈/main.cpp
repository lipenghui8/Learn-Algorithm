#include <iostream>

using namespace std;
#define MAXSIZE 100;
typedef int SElemType;
typedef struct{
    SElemType data;
    SElemType *next;
}StackNode,*LinkStack;
//��ʼ����ջ
void InitStack(LinkStack&S)
{
    S=NULL;
}
//�ж���ջ�Ƿ�Ϊ��
bool StackEmpty(LinkStack S)
{
    if(S==NULL) return 1;
    else return 0;
}
//��ջ��ջ
int Push(LinkStack &S,SElemType e)
{
    p=new StackNode;
    p->data=e;
    p->next=S;
    S=p;
    return 1;
}
//��ջ��ջ
int Pop(LinkStack &S,SElemType&e)
{
    if(S==NULL) return 0;
    e=S->data;
    p=S;
    S=S->next;
    delete p;
    return 1;
}
//�����ʾ��Ϣ
void welcome()
{
    cout<<"****************"<<endl;
    cout<<"������ָ�"<<endl;
    cout<<"****************"<<endl;
}
int main()
{
    StackNode S;
    SElemType e;
    welcome();

    return 0;
}
