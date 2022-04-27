#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <string.h>
#include <cmath>
#include <vector>
#include <stack>
//词法分析器
#include "CIFA.h"
using namespace std;
//const int N=100;
//const int MAXSIZE=1000;
//产生式存储
typedef struct Product{
    char left;
    char right[N];
    int length;
}Product;
//状态闭包集存储
typedef struct I{
    vector<Product> pros;
}I;
//follow集存储
typedef struct Follow{
    char V;
    vector<char> fset;
}Follow;
//闭包集 集合
vector<I> Is;
//follow集 集合
vector<Follow> FollowSet;
int prod_len;
//产生式集
Product products[MAXSIZE];

//非终结符集，终结符集
char V[MAXSIZE];int V_len=0;
char T[MAXSIZE];int T_len=0;

//action goto 表
char _action[MAXSIZE][MAXSIZE];
int _goto[MAXSIZE][MAXSIZE];
//action 表初始化
void init_action(){
    for(int i=0;i<MAXSIZE;i++)
        for(int j=0;j<MAXSIZE;j++)
        _action[i][j]='e';
}
//goto 表初始化
void init_goto(){
    for(int i=0;i<MAXSIZE;i++)
        for(int j=0;j<MAXSIZE;j++)
        _goto[i][j]=-1;
}
//字符串比对函数
bool mystrcmp(char *s,char *p){
    int i=0,j=0;
    while(s[i]!='\0' && p[j]!='\0' && s[i]==p[j]){++i;++j;}
    if(s[i]=='\0' && p[j]=='\0')return true;
    else return false;
}
//判断产生式是否相同
bool is_sameProduct(Product a,Product b){
    if(a.length!=b.length)return false;
    if(a.left==b.left && mystrcmp(a.right,b.right))return true;
    else return false;
}
//判断是否为操作符
bool is_operate(char c){
    char op[N]="+-*/=&|><";
    int i=0;
    while(op[i]!='\0'){
         if(op[i]==c)return true;
         i++;
    }
    return false;
}
//判断是否为非终结符
bool is_signV(char c){
    if(c>='A' && c<='Z')return true;
    else return false;
}
//判断状态闭包集是否相同
bool is_sameI(I a,I b){
    if(a.pros.size()!=b.pros.size())return false;
    int i,j;
    int cnt=0;
    for(i=0;i<a.pros.size();i++){
        for(j=0;j<b.pros.size();j++){
            if(is_sameProduct(a.pros[i],b.pros[j])){cnt++;break;}
        }
    }
    if(cnt==a.pros.size()){
        return true;
    }
    else return false;
}
//产生式拷贝
Product newProduct(Product a){
    Product ans;
    ans.left=a.left;
    strcpy(ans.right,a.right);
    ans.length=a.length;
    return ans;
}
//下标索引转换
int changIndex(char c){
    for(int i=0;i<T_len;i++){
        if(T[i]==c)return i;
    }
    for(int i=0;i<V_len;i++){
        if(V[i]==c)return T_len+i;
    }
    return -1;
}
//判断产生式是否在闭包集中
bool is_inI(I s,Product a){
    for(int i=0;i<s.pros.size();i++){
        if(is_sameProduct(s.pros[i],a))return true;
    }
    return false;
}
//输出产生式
void print_product(Product a){
    printf("%c->%s\n",a.left,a.right);
}
//输出产生式 --- 保存文件
void print_I(I a,int ans){
    char filename[10]="Is/I";
    int t=0,cnt=ans;
    string s="";
    while(filename[t]!='\0')t++;
    while(cnt){s+=(cnt%10)+'0';cnt/=10;}
    for(int i=s.size()-1;i>=0;i--)filename[t++]=s[i];
    filename[t++]='.';filename[t++]='t';filename[t++]='x';filename[t++]='t';
    filename[t]='\0';
    FILE *fp=fopen(filename,"w");
    for(int i=0;i<a.pros.size();i++){
        fprintf(fp,"%c->%s\n",a.pros[i].left,a.pros[i].right);
    }
    fclose(fp);
}
//判断是否是对应产生式
bool judge_product(Product a,Product b){
    int i=1,j=0;
    while(a.right[i]!='\0' && b.right[j]!='.' && a.right[i]==b.right[j]){++i;++j;}
    if(a.left==b.left && a.right[i]=='\0' && b.right[j]=='.')return true;
    else return false;
}
//闭包集求解
I close(I a){
    for(int i=0;i<a.pros.size();i++){
            char *s=a.pros[i].right;
            int k=0;
            while(s[k]!='\0' && s[k]!='.')k++;
            char c=s[k+1];
            if(c!='\0' && c>='A' && c<='Z'){
                for(int j=0;j<prod_len;j++){
                    if(products[j].left==c){
                        if(!is_inI(a,products[j]))
                            a.pros.push_back(products[j]);
                    }
                }
            }
        }
        return a;
}
//寻找非终结符对应follow集
int findFollow(char v){
    for(int i=0;i<FollowSet.size();i++){
        if(FollowSet[i].V==v)return i;
    }
    return -1;
}
//寻找产生式
int findProduct(Product a){
    for(int i=0;i<prod_len;i++){
        if(judge_product(products[i],a))return i;
    }
    return -1;
}
//SLR
void SLR(){
    I t;
    t.pros.push_back(products[0]);
    t=close(t);
    Is.push_back(t);
    int z=0;
    do{
        /*求状态闭包集*/
        /*状态转移---非终结符*/
        for(int m=0;m<V_len;m++){
            I t;
            for(int n=0;n<Is[z].pros.size();n++){
                Product ans=newProduct(Is[z].pros[n]);
                int k=0;
                while(ans.right[k]!='\0' && ans.right[k]!='.')k++;
                if(ans.right[k+1]=='\0')continue;
                if(V[m]==ans.right[k+1]){
                    swap(ans.right[k],ans.right[k+1]);
                    t.pros.push_back(ans);

                }
            }
            t=close(t);
            if(t.pros.size()==0)continue;
            int u;
            for(u=0;u<Is.size();u++){
                if(is_sameI(Is[u],t)){
                    int xx=z,yy=changIndex(V[m]);
                    _goto[xx][yy]=u;
                    break;
                }
            }
            if(u==Is.size()){
                Is.push_back(t);
                 int xx=z,yy=changIndex(V[m]);
                 _goto[xx][yy]=Is.size()-1;
            }
        }

        for(int m=0;m<T_len;m++){
            if(T[m]=='\0')continue;
            I t;
            for(int n=0;n<Is[z].pros.size();n++){
                Product ans=newProduct(Is[z].pros[n]);
                int k=0;
                while(ans.right[k]!='\0' && ans.right[k]!='.')k++;
                if(ans.right[k+1]=='\0')continue;
                if(T[m]==ans.right[k+1]){
                    swap(ans.right[k],ans.right[k+1]);
                    t.pros.push_back(ans);

                }
            }
            t=close(t);
            if(t.pros.size()==0)continue;
            int u;
            for(u=0;u<Is.size();u++){
                if(is_sameI(Is[u],t)){
                    int xx=z,yy=changIndex(T[m]);
                    _action[xx][yy]='s';
                    _goto[xx][yy]=u;
                    break;
                }
            }
            if(u==Is.size()){
                Is.push_back(t);
                int xx=z,yy=changIndex(T[m]);
                _action[xx][yy]='s';
                _goto[xx][yy]=Is.size()-1;
            }
        }
        z++;
    }while(z<Is.size());
    //printf("66\n");

    int l,xx,yy,index,r;
    for(int i=0;i<Is.size();i++){
        for(int j=0;j<Is[i].pros.size();j++){
            l=Is[i].pros[j].length;
            if(Is[i].pros[j].right[l-1]=='.'){
                xx=i;index=findFollow(Is[i].pros[j].left);
                //printf("%d \n",index);
                r=findProduct(Is[i].pros[j]);
                for(int k=0;k<FollowSet[index].fset.size();k++){
                    yy=changIndex(FollowSet[index].fset[k]);
                    _action[xx][yy]='r';
                    _goto[xx][yy]=r;
                }
            }

        }
    }
    _action[1][T_len-1]='a';
}
//初始化非终结符
void init_V(){
    char c;
    int i,j;
    for(i=0;i<prod_len;i++){
        c=products[i].left;
        //printf("%c",c);
        for(j=0;j<V_len;j++){
            if(c==V[j]){break;}
        }
        if(j==V_len){V[V_len]=c;V_len++;}
    }
    //for(int i=0;i<V_len;i++){printf("%c ",V[i]);}
}
//初始化终结符
void init_T(){
    char *s,c;
    int i,j,k;
    for(i=0;i<prod_len;i++){
        s=products[i].right;
        k=0;
        while(s[k]!='\0'){
            c=s[k];k++;
            if((c>'Z' || c<'A') && c!='#'){
                //printf("%c ",c);
                for(j=0;j<T_len;j++){
                    if(c==T[j]){break;}
                }
                if(j==T_len){T[T_len]=c;T_len++;}
            }

        }
    }
    T[T_len++]='\0';
    //for(int i=0;i<T_len;i++){printf("%c ",T[i]);}
    //printf("\n");
}
//初始化follow集
/*暂时还无法用程序实现*/
void init_Follow(){
    FILE * fp=fopen("Follow.txt","r");
    char ans[N];
    int v,k;
    while(!feof(fp)){
        fscanf(fp,"%s",ans);
        k=0;
        Follow t;
        while(ans[k]!='\0' && ans[k]!=EOF){
            if(ans[k]>='A' && ans[k]<='Z')t.V=ans[k];
            else {
                if(ans[k]=='#')t.fset.push_back('\0');
                else t.fset.push_back(ans[k]);
            }
            k++;
        }
        FollowSet.push_back(t);
        fgetc(fp);
    }
    fclose(fp);
}
//读取文件中的产生式
void GetProduct(char *filename){
    FILE  *fp=fopen(filename,"r");
    int ans;
    char c;
    prod_len=0;
    while(!feof(fp)){
        fscanf(fp,"%c->%s",&products[prod_len].left,products[prod_len].right);
        c=fgetc(fp);
        ans=0;
        while(products[prod_len].right[ans]!='\0')ans++;
        products[prod_len].length=ans;
        prod_len++;
    }
    fclose(fp);
}
//更新产生式
char* updateProduct(){
    FILE * fp=fopen("t_WENFA.txt","w");
    for(int i=0;i<prod_len;i++){
        if(i==prod_len-1){
            if(mystrcmp("#",products[i].right))fprintf(fp,"%c->.",products[i].left);
            else fprintf(fp,"%c->.%s",products[i].left,products[i].right);
        }
        else{
            if(mystrcmp("#",products[i].right))fprintf(fp,"%c->.\n",products[i].left);
            else fprintf(fp,"%c->.%s\n",products[i].left,products[i].right);
        }
    }
    fclose(fp);
    return "t_WENFA.txt";
}
//错误处理
void error(int eline,stack<char> s,char c,FILE *fp){
    if(s.empty())return ;
    int i,j,index,t=0;
    char tmp[20],ct;
    vector<char> ans(s.size());
    for(i=ans.size()-1;i>=0;i--){
        ans[i]=s.top();s.pop();
    }
    if(is_operate(ans[ans.size()-1])){insert_error(eline,"操作数","语法错，此处缺少");}
    bool judge=false;
    for(i=0;i<ans.size();i++)
    {
        if(ans[i]=='(')judge=true;
        if(ans[i]==')')judge=false;
    }
    if(judge){insert_error(eline,")","语法错，此处缺少");}
    judge=false;
    for(i=0;i<ans.size();i++)
    {
        if(ans[i]=='{')judge=true;
        if(ans[i]=='}')judge=false;
    }
    if(judge){insert_error(eline,"}","语法错，此处缺少");}
//    for(i=0;i<ans.size();i++){cout<<ans[i]<<" ";}
//    cout<<endl;
    for(i=0;i<prod_len;i++){
        j=0;
        while(j<products[i].length && j<ans.size() && products[i].right[j]==ans[j])j++;
        //cout<<i<<endl;
        if(j==ans.size()){
            while(products[i].right[j]!='\0'){
                if(products[i].right[j]<'A' || products[i].right[j]>'Z')tmp[t++]=products[i].right[j++];
                else break;
                //cout<<tmp[t-1]<<endl;
            }
            //print_product(products[i]);
            tmp[t]='\0';
            if(t==1){
                if(tmp[0]=='@' || tmp[0]=='$')
                    {insert_error(eline,"操作数","语法错，此处缺少");return ;}
                else{
                    if(is_operate(tmp[0])){insert_error(eline,tmp,"语法错，此处缺少");return ;}
                    else{
                        insert_error(eline,tmp,"语法错，非法字符");
                        return ;
                    }
                }

            }else if(t>1){
                if(t>1)insert_error(eline,tmp,"语法错，此处缺少");
                return ;
            }else{
                tmp[t++]=c;
                while((ct=fgetc(fp))!=EOF){
                        if(ct>='a' && ct<='z')tmp[t++]=ct;
                        else break;
                }
                tmp[t]='\0';
                insert_error(eline,tmp,"语法错，非法字符");
                return ;
            }

        }
    }
    //for(int i=0;i<=Erlen;i++){printf("%d :%s  %s\n",Errors[i].line,Errors[i].info,Errors[i].c);}
    //exit(0);
}
//更新action表
void update_action(){
    FILE *file_action=fopen("action.txt","w");
    fprintf(file_action,"\t");
    for(int i=0;i<T_len;i++){
        if(T[i]!='\0')fprintf(file_action,"%c\t",T[i]);
        else fprintf(file_action,"#\t");
    }
    fprintf(file_action,"\n");
    for(int i=0;i<Is.size();i++)
    {
        fprintf(file_action,"%d\t",i);
        for(int j=0;j<T_len;j++)
            fprintf(file_action,"%c\t",_action[i][j]);
        fprintf(file_action,"\n");
    }
    fclose(file_action);
}
//更新goto表
void update_goto(){
    FILE *file_goto=fopen("goto.txt","w");
    fprintf(file_goto,"\t");
    for(int i=0;i<T_len;i++){
            if(T[i]!='\0')fprintf(file_goto,"%c\t",T[i]);
            else fprintf(file_goto,"#\t");
    }
    for(int i=0;i<V_len;i++){fprintf(file_goto,"%c\t",V[i]);}
    fprintf(file_goto,"\n");
    for(int i=0;i<Is.size();i++)
    {
        fprintf(file_goto,"%d\t",i);
        for(int j=0;j<V_len+T_len;j++)
            fprintf(file_goto,"%d\t",_goto[i][j]);
        fprintf(file_goto,"\n");
    }
    fclose(file_goto);
}
//SLR驱动程序
void SLR_Driver(){
    FILE *fp_Token=fopen("Token.txt","r");
    FILE *fp_debug=fopen("debug.txt","w");
    stack<int> s_state;
    stack<char> s_char;
    int i=0,pos,state,code_line=1,ju=10;
    char ans,c,s[N];
    s_state.push(0);
    c=fgetc(fp_Token);
    while(1){
        if(c=='\n'){c=fgetc(fp_Token);code_line++;continue;}
        if(c==EOF){c='\0';}
        state=s_state.top();
        pos=changIndex(c);
        ans=_action[state][pos];
                //cout<<"状态栈顶"<<" "<<"符号栈顶"<<endl;
        fprintf(fp_debug,"状态栈顶   符号栈顶\n");
        if(!s_state.empty()&&!s_char.empty()){
                //cout<<s_state.top()<<" "<<s_char.top()<<endl;
                fprintf(fp_debug,"%d   %c\n",s_state.top(),s_char.top());
        }
        //cout<<c<<" "<<" "<<ans<<" "<<_goto[state][pos]<<endl;
        fprintf(fp_debug,"%c   %c   %d\n",c,ans,_goto[state][pos]);
        switch(ans){
                case 's':{s_state.push(_goto[state][pos]);s_char.push(c);c=fgetc(fp_Token);break;}
                case 'r':{
                    if(products[_goto[state][pos]].right[0]!='#')
                        for(int i=0;i<products[_goto[state][pos]].length;i++){s_state.pop();s_char.pop();}
                    s_char.push(products[_goto[state][pos]].left);
                    s_state.push(_goto[s_state.top()][changIndex(s_char.top())]);
                    break;
                }
                case 'a':{
                    if(Erlen<0)
                        printf("Accept,语法分析成功666\n");
                    return ;
                }
                default :{
                    //cout<<c<<endl;
                    error(code_line,s_char,c,fp_Token);
                    s_char=stack<char>();
                    s_state=stack<int>();s_state.push(0);
                    c=fgetc(fp_Token);
                    if(c==EOF)return ;
                    break;
                }
            }
    }
    fclose(fp_Token);
    fclose(fp_debug);
}
int main()
{
    ci_start();
    if(Erlen!=-1){
        printf("词法分析错误\n");
        for(int i=0;i<=Erlen;i++){printf("%d :%s  %s\n",Errors[i].line,Errors[i].info,Errors[i].c);}
        exit(0);
    }
    GetProduct("WENFA.txt");
    init_V();
    init_T();
    init_Follow();
    char *filename=updateProduct();
    GetProduct(filename);
    init_action();init_goto();
    SLR();
    update_action();
    update_goto();
    for(int i=0;i<Is.size();i++){print_I(Is[i],i);}
    GetProduct("WENFA.txt");
    update_action();
    update_goto();
    SLR_Driver();
    for(int i=0;i<=Erlen;i++){printf("%d :%s  %s\n",Errors[i].line,Errors[i].info,Errors[i].c);}

    return 0;
}
