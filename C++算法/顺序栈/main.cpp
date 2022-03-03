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

//��ʼ��ջ
int InitStack(SqStack&S)
{
    S.base=new SElemType[MAXSIZE];
    S.top=S.base;
    S.stacksize=MAXSIZE;
    return 1;
}
//�ж�ջ�Ƿ�Ϊ��
bool StackEmpty(SqStack S)
{
    if(S.top==S.base) return true;
    else return false;
}
//��˳��ջ�ĳ���
int StackLength(SqStack S)
{
    return S.top-S.base;
}
//���˳��ջ
int ClearStack(SqStack &S)
{
    if(S.base) S.top=S.base;
    return 1;
}
//����˳��ջ
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
//��ջ
int Push(SqStack &S,SElemType e)
{
    if(S.top-S.base==S.stacksize)
        return 0;
    *S.top++=e;
    return 1;
}
//��ջ
int Pop(SqStack &S,SElemType&e)
{
    if(S.top==S.base)
        return 0;
    e=*--S.top;
    return 1;
}
//ȡջ��Ԫ��
int GetTop(SqStack S,SElemType&e)
{
    if(S.top==S.base) return 0;
    e=*(S.top-1);
    return 1;
}
//���ջ��Ԫ��
void print(SqStack S)
{
    while(S.top!=S.base)
    {
        cout<<*(S.top-1);
        S.top--;
    }
}
//����������ջԪ��
void BulidStack(SqStack &S,int n)
{
    while(n--)
    {
        cin>>*S.top;
        S.top++;
    }
}
//�����ʾ��Ϣ
void welcome()
{
    cout<<"****************"<<endl;
    cout<<"1.��ʼ��Ϊ��ջ"<<endl;
    cout<<"2.����ջ"<<endl;
    cout<<"3.��ջ�ÿ�"<<endl;
    cout<<"4.�ж�ջ�Ƿ�Ϊ��ջ"<<endl;
    cout<<"5.����ջ�ĳ���"<<endl;
    cout<<"6.��ջ��Ԫ��"<<endl;
    cout<<"7.����Ԫ�أ���ʹ���Ϊջ��Ԫ��"<<endl;
    cout<<"8.ɾ��ջ��Ԫ�أ���������ֵ"<<endl;
    cout<<"9.���ջ��Ԫ��"<<endl;
    cout<<"10.����������ջԪ��"<<endl;
    cout<<"11.�˳�"<<endl;
    cout<<"12.��������ת������"<<endl;
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
    cout<<"���������ѡ��>>";
    while(cin>>n)
    {
        switch(n)
        {
        case 1:
            mes=InitStack(S);
            if(mes)
                cout<<"��ʼ���ɹ���"<<endl;
            break;
        case 2:
            if(!IsLegal(S)){
                cout<<"ջδ��ʼ����"<<endl;
                break;
            }
            mes=DestroyStack(S);
            if(mes)
                cout<<"���ٳɹ���"<<endl;
            break;
        case 3:
            if(!IsLegal(S)){
                cout<<"ջδ��ʼ����"<<endl;
                break;
            }
            mes=ClearStack(S);
            if(mes)
                cout<<"ջ���ÿգ�"<<endl;
            break;
        case 4:
            if(!IsLegal(S)){
                cout<<"ջδ��ʼ����"<<endl;
                break;
            }
            if(StackEmpty(S))
                cout<<"ջΪ�գ�"<<endl;
            else
                cout<<"�ǿգ�"<<endl;
            break;
        case 5:
            if(!IsLegal(S)){
                cout<<"ջδ��ʼ����"<<endl;
                break;
            }
            mes=StackLength(S);
            cout<<"ջ�ĳ���Ϊ��"<<mes<<endl;
            break;
        case 6:
            if(!IsLegal(S)){
                cout<<"ջδ��ʼ����"<<endl;
                break;
            }
            mes=GetTop(S,e);
            if(mes)
                cout<<"ջ��Ԫ��Ϊ��"<<e<<endl;
            else
                cout<<"����ʧ�ܣ�"<<endl;
            break;
        case 7:
            if(!IsLegal(S)){
                cout<<"ջδ��ʼ����"<<endl;
                break;
            }
            cout<<"������һ��Ԫ�أ�";
            cin>>e;
            mes=Push(S,e);
            if(mes)
                cout<<"��ջ�ɹ���"<<endl;
            else
                cout<<"����ʧ�ܣ�"<<endl;
            break;
        case 8:
            if(!IsLegal(S)){
                cout<<"ջδ��ʼ����"<<endl;
                break;
            }
            mes=Pop(S,e);
            if(mes)
                cout<<"ջ��Ԫ��Ϊ��"<<e<<endl;
            else
                cout<<"����ʧ�ܣ�"<<endl;
            break;
        case 9:
            if(!IsLegal(S)){
                cout<<"ջδ��ʼ����"<<endl;
                break;
            }
            print(S);
            cout<<endl;
            break;
        case 10:
            cout<<"������Ҫ��ʼ����Ԫ�ظ�����";
            cin>>mes;
            cout<<"������"<<mes<<"��Ԫ�أ�"<<endl;
            BulidStack(S,mes);
            break;
        case 11:
            return 0;
            break;
        case 12:
            cout<<"������Ҫת�������֣�";
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
            cout<<"��������"<<endl;
        }
        cout<<"���������ѡ��>>";
    }
    return 0;
}
