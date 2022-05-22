// pL/0语言词法分析器
#include<bits/stdc++.h>
using namespace std;

ifstream infile("D:/Test/c.txt");//词法分析的结果或语法分析的输入
string str;//string变量进行字符识别
string sym; //指针

void expressionAnalysis();//表达式分析
void termAnaysis();//项分析
void factorAnalysis();//因子分析
int advance();

int conterr=0;//记录错误
int lpnum=0;//记录左括号
int found;//提取字符串中指针的位置
int flag=0;//记录往后移动一个指针SYM是否正确
string s;//用来保存要分析的字符串
struct _2tup
{
    string token;
    int id;
};

int advance(){//SYM的移动
    if(!getline(infile,str)){//从文件中提取字符
        return 0;
    }
    found=str.find(',',0);
    if(found==-1){//当为error的时候，没有‘，’
        conterr++;
        cout<<"语法错误 识别字符错误"<<endl;
        return -1;
    }
    sym=str.substr(1,found-1);
    //cout<<sym<<endl;
    return 1;
}

void factorAnalysis(){//识别分析标识符
    if(sym=="29"||sym=="28"){//如果是标识符和无符号整数，指针就往后移动
        flag=advance();
        if(conterr){
            return;
        }
        if(lpnum==0&&sym=="22"){//
            conterr++;
            cout<<"语法错误 ')'不匹配"<<endl;
            return;
        }
    }
    else if(sym=="21"){//如果是左括号，就要接下来判断是否为表达式，指针往后移动
        lpnum++;
      //  cout<<lpnum<<endl;
        flag=advance();
        if(conterr){
            return;
        }
        if(flag==0){//当为最后一个标志的时候，若没有右括号匹配就错误
            conterr++;
            cout<<"语法错误 '('后缺少表达式"<<endl;
            return;
        }
        expressionAnalysis();
        if(conterr){
            return;
        }
        if(flag==0||sym!="22"){
            conterr++;
            cout<<"语法错误 表达式后面缺少')'"<<endl;
            return;
        }else{
            lpnum--;
            flag=advance();
            if(conterr){
                return;
            }
            if(flag==0){
                return;
            }
        }
    }else{
        cout<<"语法错误 因子首部不为<标识符>|| <无符号整数> ||'('"<<endl;
        conterr++;
        return;
    }
    return;
}

void termAnalysis(){//识别分析乘除符号
    factorAnalysis();
    if(conterr){
        return;
    }
    while((sym=="14")||(sym=="15")){//当为'*'或'/'的时候，一直往后识别因子并循环
        flag=advance();
        if(conterr){
            return;
        }
        if(flag==0){
            conterr++;
            cout<<"语法错误 <乘除法运算符>后缺因子"<<endl;
            return;
        }
        if(conterr){
            return;
        }
        factorAnalysis();
        if(conterr){
            return;
        }
    }
    return;
};

void expressionAnalysis(){//识别分析加减符号
    if(conterr){
        return;
    }
    if((sym=="12")||(sym=="13")){//当为'+'或'-'的时候
        flag=advance();
        if(!conterr){
            return;
        }
        if(flag==0){
            cout<<"语法错误 <加减法运算符>后缺项"<<endl;
            conterr++;
            return;
        }
    }
    termAnalysis();
    if(conterr){
        return;
    }
    while((sym=="12")||(sym=="13")){//当为'+'或'-'的时候，一直往后识别项并循环
        flag=advance();
        if(conterr){
            return;
        }
        if(flag==0){
            cout<<"语法错误 <加法运算符>后缺项"<<endl;
            conterr++;
            return;
        }
        termAnalysis();
        if(conterr){
            return;
        }
    }
    return;
}

bool is_blank(char ch)
{
    return ch == ' ' || ch == '    ';//空格或控制字符
}
bool gofor(char& ch, string::size_type& pos, const string& prog)//返回指定位置的字符
{
    ++pos;
    if (pos >= prog.size())
    {
        return false;
    }
    else
    {
        ch = prog[pos];
        return true;
    }
}

_2tup scanner(const string& prog, string::size_type& pos, const map<string, int>& keys, int& row)
{
    /*
    if
        标示符
    else if
        数字
    else
        符号
    */
    _2tup ret;
    string token;
    int id = 0;

    char ch;
    ch = prog[pos];

    while(is_blank(ch))
    {
        ++pos;
        ch = prog[pos];
    }
    // 判断标示符、关键字
    if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '_')
    {
        //保证读取一个单词
        while((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '_')
        {
            token += ch;//追加标示符、关键字
            if (!gofor(ch, pos, prog))
            {
                break;
            }
        }
        // 这里先看做都是其他标示符
        id = keys.size();

        // 验证是否是关键字
        map<string, int>::const_iterator cit = keys.find(token);//根据string类型的token返回int类型的id赋值给cit
        if (cit != keys.end())
        {
            id = cit->second;//此时是关键字，记录他的id
        }
    }
    // 识别常数
    else if ((ch >= '0' && ch <= '9') || ch == '.')
    {
        while (ch >= '0' && ch <= '9' || ch == '.')
        {
            token += ch;
            if (!gofor(ch, pos, prog))
            {
                break;
            }
        }
        id = keys.size() - 1;
        int dot_num = 0;
        for (string::size_type i = 0; i != token.size(); ++i)
        {
            if (token[i] == '.')
            {
                ++dot_num;
            }
        }
        if (dot_num > 1)
        {
            id = -1;
        }
    }
    else
    {
        map<string, int>::const_iterator cit;
        switch (ch)
        {
        case '-': // - 操作符
            token += ch;
            if (gofor(ch, pos, prog))
            {
                if (ch == '-' || ch == '=' || ch == '>') // -- 操作符
                {
                    token += ch;
                    gofor(ch, pos, prog);
                }
            }
            cit = keys.find(token);
            if (cit != keys.end())
            {
                id = cit->second;
            }
            break;
        case ':':
             token += ch;
            if (gofor(ch, pos, prog))
            {
                if (ch == '=') // -- 操作符
                {
                    token += ch;
                    gofor(ch, pos, prog);
                }
            }
            cit = keys.find(token);
            if (cit != keys.end())
            {
                id = cit->second;
            }
            break;

        case '=':
            token += ch;
            if (gofor(ch, pos, prog))
            {
                if (ch == '=') // !% %= 操作符
                {
                    token += ch;
                    gofor(ch, pos, prog);
                }
            }
            cit = keys.find(token);
            if (cit != keys.end())
            {
                id = cit->second;
            }
            break;

        case '/': // / 操作符
            token += ch;
            if (gofor(ch, pos, prog))
            {
                if (ch == '=') // /= 操作符
                {
                    token += ch;
                    gofor(ch, pos, prog);
                }
                else if (ch == '/') // 单行注释
                {
                    token += ch;
                    ++pos;
                    while (pos < prog.size())
                    {
                        ch = prog[pos];
                        if (ch == '\n')
                        {
                            break;
                        }
                        token += ch;
                        ++pos;
                    }
                    if (pos >= prog.size())
                    {
                        ;
                    }
                    else
                    {
                        ;
                    }
                    id = keys.size() - 2;
                    break;
                }
                else if (ch == '*') // 注释
                {
                    token += ch;
                    if (!gofor(ch, pos, prog))
                    {
                        token += "\n!!!注释错误!!!";
                        id = -10;
                        break;
                    }
                    if (pos + 1 >= prog.size())
                    {
                        token += ch;
                        token += "\n!!!注释错误!!!";
                        id = -10;
                        break;
                    }
                    char xh = prog[pos + 1];
                    while (ch != '*' || xh != '/')
                    {
                        token += ch;
                        if (ch == '\n')
                        {
                            ++row;
                        }
                        //++pos;
                        if (!gofor(ch, pos, prog))
                        {
                            token += "\n!!!注释错误!!!";
                            id = -10;
                            ret.token = token;
                            ret.id    = id;
                            return ret;
                        }
                        //ch = prog[pos];
                        if (pos + 1 >= prog.size())
                        {
                            token += ch;
                            token += "\n!!!注释错误!!!";
                            id = -10;
                            ret.token = token;
                            ret.id    = id;
                            return ret;
                        }
                        xh = prog[pos + 1];
                    }
                    token += ch;
                    token += xh;
                    pos += 2;
                    ch = prog[pos];
                    id = keys.size() - 2;
                    break;
                }
            }
            cit = keys.find(token);
            if (cit != keys.end())
            {
                id = cit->second;
            }
            break;
        case '+':
            token += ch;
            cit = keys.find(token);
            if (cit != keys.end())
            {
                id = cit->second;
            }
            gofor(ch, pos, prog);
            break;

        case '<':
            token += ch;
            if (gofor(ch, pos, prog))
            {
                if (ch == '<')
                {
                    token += ch;
                    if (gofor(ch, pos, prog))
                    {
                        if (ch == '=')
                        {
                            token += ch;
                            gofor(ch, pos, prog);
                        }
                    }
                }
                else if (ch == '=')
                {
                    token += ch;
                    gofor(ch, pos, prog);
                }
            }
            cit = keys.find(token);
            if (cit != keys.end())
            {
                id = cit->second;
            }
            break;

        case '>':
            token += ch;
            if (gofor(ch, pos, prog))
            {
                if (ch == '>')
                {
                    token += ch;
                    if (gofor(ch, pos, prog))
                    {
                        if (ch == '=')
                        {
                            token += ch;
                            gofor(ch, pos, prog);
                        }
                    }
                }
                else if (ch == '=')
                {
                    token += ch;
                    gofor(ch, pos, prog);
                }
            }
            cit = keys.find(token);
            if (cit != keys.end())
            {
                id = cit->second;
            }
            break;
         case '(': // / 操作符
            token += ch;
            if (gofor(ch, pos, prog))

            {
                 if (ch == '*') // 注释
                {
                    token += ch;
                    if (!gofor(ch, pos, prog))
                    {
                        token += "\n!!!注释错误!!!";
                        id = -10;
                        break;
                    }
                    if (pos + 1 >= prog.size())
                    {
                        token += ch;
                        token += "\n!!!注释错误!!!";
                        id = -10;
                        break;
                    }
                    char xh = prog[pos + 1];
                    while (ch != '*' || xh != ')')
                    {
                        token += ch;
                        if (ch == '\n')
                        {
                            ++row;
                        }
                        //++pos;
                        if (!gofor(ch, pos, prog))
                        {
                            token += "\n!!!注释错误!!!";
                            id = -10;
                            ret.token = token;
                            ret.id    = id;
                            return ret;
                        }
                        //ch = prog[pos];
                        if (pos + 1 >= prog.size())
                        {
                            token += ch;
                            token += "\n!!!注释错误!!!";
                            id = -10;
                            ret.token = token;
                            ret.id    = id;
                            return ret;
                        }
                        xh = prog[pos + 1];
                    }
                    token += ch;
                    token += xh;
                    pos += 2;
                    ch = prog[pos];
                    id = keys.size() - 2;
                    break;
                }
            }
            cit = keys.find(token);
            if (cit != keys.end())
            {
                id = cit->second;
            }
            break;

        case '*':
            token += ch;
            cit = keys.find(token);
            if (cit != keys.end())
            {
                id = cit->second;
            }
             gofor(ch, pos, prog);
            break;

        case ',':
        case ')':
        case '#':
        case '.':
        case ';':
            token += ch;
            gofor(ch, pos, prog);
            //++pos;
            //ch = prog[pos];
            cit = keys.find(token);
            if (cit != keys.end())
            {
                id = cit->second;
            }
            break;

        case '\n':
            token += "换行";
            ++pos;
            ch = prog[pos];
            id = -2;
            break;
        default:
            token += "错误";
            ++pos;
            ch = prog[pos];
            id = -1;
            break;
        }
    }
    ret.token = token;
    ret.id    = id;

    return ret;
}

void init_keys(const string& file, map<string, int>& keys)//读取单词符号和种别码
{
    ifstream fin(file.c_str());//.c_str返回的是当前字符串的首地址
    if (!fin)
    {
        cerr << file << " doesn't exist!" << endl;//cerr不经过缓冲而直接输出,一般用于迅速输出出错信息
      //  exit(1);
    }
    keys.clear();//清空map对象里面的内容
    string line;
    string key;
    int id;
    while (getline(fin, line))//这个函数接收两个参数：一个输入流对象和一个string对象，getline函数从输入流的下一行读取，并保存读取的内容到string中
    {
        istringstream sin(line);//istringstream sin(s);定义一个字符串输入流的对象sin,并调用sin的复制构造函数，将line中所包含的字符串放入sin 对象中！
        sin >> key >> id;//读取里面的字符串每一行一个key id
        keys[key] = id;
    }
}

void read_prog(const string& file, string& prog){//读取代码，并追加到prog上
    ifstream fin(file.c_str());
    if (!fin)
    {
        cerr << file << " error!" << endl;
      //  exit(2);
    }
    prog.clear();
    string line;
    while (getline(fin, line))
    {
        prog += line + '\n';
    }
}

void cifafenxi()
{
    map<string, int> keys;
    init_keys("D:/Test/a.txt", keys);

    string prog;
    cin>>prog;
    //read_prog("D:/Test/b.txt", prog);

    vector< _2tup > tups;
    string token, id;

    string::size_type pos = 0;//size_type属于string标准库，作用可看做相当于unsigned·int
    int row  = 1;

    _2tup tu;
    int no = 0;
    freopen("D:/Test/c.txt","w",stdout);
    do
    {
        tu = scanner(prog, pos, keys, row);

        switch (tu.id)
        {
        case -1://返回的是错误
            ++no;
            cout << no << ": ";
            cout << "Error in row" << row << "!" << '<' << tu.token<< "," << tu.id << '>' << endl;
            tups.push_back(tu);
            break;
        case -2:
            ++row;
            // cout << '<' << tu.token<< "," << tu.id << '>' << endl;
            break;
        default:

                s=prog;
                cout << '(' << tu.id<< "," << tu.token << ')' << endl;

            tups.push_back(tu);
            break;
        }
    } while (pos < prog.size());

}

yufafenxi()//语法分析
{
    freopen("CON", "w", stdout);//结果在控制台上输出
     flag=advance();
    if(flag){
        expressionAnalysis();
    }
    if(flag!=-1&&!conterr){
        cout<<"正确："<<s<<endl;
    }

}
int main()
{
    cifafenxi();
    yufafenxi();
    return 0;
}
