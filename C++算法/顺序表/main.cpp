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
//�˵���Ϣ
void Menu()
{
    cout<<"1----��ʼ��һ�����Ա�"<<endl;
    cout<<"2----�������Ա�"<<endl;
    cout<<"3----������Ա�"<<endl;
    cout<<"4----�ж����Ա��Ƿ�Ϊ��"<<endl;
    cout<<"5----�����Ա���"<<endl;
    cout<<"6----��ȡ���Ա��ƶ�λ��Ԫ��"<<endl;
    cout<<"7----��ǰ��"<<endl;
    cout<<"8----����"<<endl;
    cout<<"9----�����Ա�ָ��λ�ò���Ԫ��"<<endl;
    cout<<"10---ɾ�����Ա�ָ��λ��Ԫ��"<<endl;
    cout<<"11---��ʾ���Ա�"<<endl;
    cout<<"     �˳�������һ��������"<<endl;
}
//��ʼ��
Status InitList(SqList &L)
{
    L.elem=new ElemType[MAXSIZE];
    if(!L.elem) exit(0);
    L.length=0;
    return 1;
}
//ȡֵ
Status GetElem(SqList L,int i,ElemType &e)
{
    if(i<1||i>L.length) return 0;
    e=L.elem[i-1];
    return 1;
}
//���� ����ֵΪe������Ԫ�أ����������
int LocateElem(SqList L,ElemType e)
{
    for(int i=0;i<L.length;i++)
        if(L.elem[i]==e) return i+1;
    return 0;
}
//����
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
//��ǰ��
ElemType BeforeElem(ElemType L,int i)
{
    return L.elem[i-1];
}
//����
ElemType AfterElem(ElemType L,int i)
{
    return L.elem[i+1];
}
//ɾ��
Status ListDelete(SqList &L,int i)
{
    if(i<1||i<L.length-1) return 0;
    for(j=i;j<=L.length-1;j++)
        L.elem[j-1]=L.elem[j];
    --L.length;
    return 1;
}
//����
Status ListDistory(SqList &L)
{
    if(L.elem) delete[] L.elem;
    L.length=0;
    L.elem=NULL;
    return 1;
}
//���
void ClearList(SqList &L)
{
    L.length=0;
    return 1;
}
//��˳�����
int GetLength(SqList L)
{
    return L.length;
}
//�ж�˳����Ƿ�Ϊ��
bool IsEmpty(SqlList L)
{
    if(L.length==0)
        return true;
    else
        return false;
}
//��ʾ���Ա�
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
                    cout<<"������Ҫ���ҵ�ֵ��";
                    cin>>e;
                    msg=GetElem(L,e);
                    break;
                case 7:
                    cout<<"������Ҫ���ҵ�Ԫ��λ��:";
                    cin>>i;
                    BeforeElem(L,i);
                    break;
                case 8:
                    cout<<"������Ҫ���ҵ�Ԫ��λ��:";
                    cin>>i;
                    BeforeElem(L,i);
                    break;
                case 9:
                    cout<<"������Ҫ�����λ�ã�";
                    cin>>i;
                    ListInsert(L,i);
                    break;
                case 10:
                    cout<<"������Ҫɾ����λ�ã�";
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
