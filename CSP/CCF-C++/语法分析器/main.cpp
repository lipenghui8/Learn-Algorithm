#include <iostream>
#include <string>
#include <iomanip>
#include <cstring>
#include <fstream>
#include <stdio.h>
#include <cassert>
#include <vector>
//#define _CRT_SECURE_NO_WARNINGS
using namespace std;
/*
begin	BEGIN	1
end		END		2
if		IF		3
then	THEN	4
else	ELSE	5
while	WHILE	6
do		DO		7
标识符	ID		8
浮点常数UCON	9
<		LT		10
<=		LE		11
==		EQ		12
<>		NE		13
>		GT		14
>=		GE		15
=		IS		16
+		PL		17
-		MI		18
*		MU		19
/		DI		20
(		LP		21  新增加的左括号
)		RP		22  新增加的右括号
*/


const char* table1[] = { " ","begin","end","if","then","else","while","do" };
const char* table2[] = { " ","BEGIN","END","IF","THEN","ELSE","WHILE","DO","ID","UCON","LT","LE","EQ","NE","GT","GE","IS","PL","MI","MU","DI","LP","RP" };
char TOKEN[20];//用来依次存放一个单词词文中的各个字符。
char str[50];//存放词法分析后的表达式，将输入的表达式转变成只含有i和运算符的表达式
int len = 0;//词法分析后表达式的长度

//action表   char vt[8] = { '(',')','+','-','*','/','i','#' };
string action[16][8] = { {"s4","null","null" ,"null" ,"null","null","s5" , "null" },
					{"null","null","s6","s7","null","null","null","acc"},
					{"null","r3","r3","r3","s8","s9","null","r3"} ,
					{"null","r6","r6","r6","r6","r6","null","r6"},
					{"s4","null","null","null","null","null","s5","null"},
					{"null","r8","r8","r8","r8","r8","null","r8"},
					{"s4","null","null","null","null","null","s5","null"},
					{"s4","null","null","null","null","null","s5","null"},
					{"s4","null","null","null","null","null","s5","null"},
					{"s4","null","null","null","null","null","s5","null"},
					{"null","s15","s6","s7","null","null","null","null"} ,
					{"null","r1","r1","r1","s8","s9","null","r1"},
					{"null","r2","r2","r2","s8","s9","null","r2"} ,
					{"null","r4","r4","r4","r4","r4","null","r4"} ,
					{"null","r5","r5","r5","r5","r5","null","r5"} ,
					{"null","r7","r7","r7","r7","r7","null","r7"} };
//go表 char vn[3] = { 'E','T','F' };
int go[16][3] = { {1 , 2 , 3 },
				{ -1 , -1 , -1 },
				{ -1 , -1 , -1 } ,
				{ -1 , -1 , -1 },
				{ 10 , 2 , 3 },
				{ -1 , -1 , -1 },
				{ -1 , 11 , 3 },
				{ -1 , 12 , 3 },
				{ -1 , -1 , 13 },
				{ -1 , -1 , 14 },
				{ -1 , -1 , -1 } ,
				{ -1 , -1 , -1 },
				{ -1 , -1 , -1 } ,
				{ -1 , -1 , -1 } ,
				{ -1 , -1 , -1 } ,
				{ -1 , -1 , -1 } };
string grammar[9] = { "S->E","E->E+T","E->E-T","E->T","T->T*F","T->T/F","T->F","F->(E)","F->i" };//存放文法表达式
int grammarlength[9] = { 4,6,6,4,6,6,4,6,4 };//每个文法表达式的长度
char grammarleft[9] = { 'S','E','E','E','T','T','T','F','F' };//文法表达式的左部
string grammarright[9] = { "E","E+T","E-T","T","T*F","T/F","F","(E)","i" };//文法表达式的右部
int grammarrightlength[9] = { 1,3,3,1,3,3,1,3,1 };//文法表达式右部长度

int lookup(char a[])/*每调用一次，就以 TOKEN 中的字符串查保留字表，若查到，就将相应关键字的类别码赋给整型变量 c；否则将 c 置为零。*/
{
	int i;
	for (i = 1; i <= 7; i++)
	{
		if (strcmp(a, table1[i]) == 0)return i;
	}
	if (i == 8)
	{
		return 0;
	}

}
void out(int a, const char b[])
/*一般仅在进入终态时调用此函数，调用的形式为 OUT(c，VAL)。
其中，实参 c 为相应单词的类别码助记符；实参 VAL 为 TOKEN（即词文）或为空串。
函数 OUT 的功能是，在送出一个单词的内部表示之后，返回到调用该词法分析程序的那个程序。*/
{
	ofstream fout("E:\\AAAtest\\result.txt", fstream::app);
	char temp = ' ';
	if (a == 8 || a == 9)
	{
		fout << "（" << table2[a] << " ，" << b << "）" << endl;
	}
	else
	{
		fout << "（" << table2[a] << " ，" << temp << "）" << endl;
	}

	fout.close();
}

void report_error(void)//返回错误
{
	ofstream fout("E:\\AAAtest\\result.txt", fstream::app);
	fout << "输入不合规范！";
	fout.close();
	return;
}
void scanner_example(FILE* fp)
{
	char ch;
	int i, c, flag = 0;;
	//ch = fgetc(fp);
	while ((ch = fgetc(fp)) != EOF)
	{
		if (ch == ' ')ch = fgetc(fp);
		if (ch == '\n')ch = fgetc(fp);
		if (ch == '#')break;
		if (isalpha(ch)) //判断字符是否为字母，识别标识符和关键字
		{
			TOKEN[0] = ch; ch = fgetc(fp); i = 1;
			while (isalnum(ch))//检查所传的字符是否是字母和数字
			{
				TOKEN[i] = ch; i++;
				ch = fgetc(fp);
			}
			TOKEN[i] = '\0';//结束符
			fseek(fp, -1, 1); //从文件当前位置后退一个字符
			c = lookup(TOKEN);//查找在第二个表中的位置，如果是关键字返回下标，标识符返回0
			if (c == 0)
			{
				out(8, TOKEN);//识别标识符
				str[len] = 'i';
				len++;
			}
			else out(c, TOKEN);//识别关键字
		}
		else if (isdigit(ch))//判断字符是否为数字字符
		{
			TOKEN[0] = ch; ch = fgetc(fp); i = 1;
			while (isdigit(ch) || ch == '.')
			{
				if (ch == '.')
				{
					if (flag == 0)
					{
						flag = 1;
						TOKEN[i] = ch; i++;
					}
					else report_error();
				}
				else
				{
					TOKEN[i] = ch; i++;

				}
				ch = fgetc(fp);
			}
			TOKEN[i] = '\0';
			fseek(fp, -1, 1);
			out(9, TOKEN);//识别数字
			str[len] = 'i';
			len++;
		}
		else
			switch (ch)
			{
			case '<': ch = fgetc(fp);
				if (ch == '=')out(11, TOKEN);//<=
				else if (ch == '>') out(13, TOKEN);//<>
				else
				{
					fseek(fp, -1, 1);
					out(10, TOKEN);//<
				}
				break;
			case '=': ch = fgetc(fp);
				if (ch == '=')out(12, TOKEN);//==
				else
				{
					fseek(fp, -1, 1);
					out(16, TOKEN);//=
				}
				break;
			case '>': ch = fgetc(fp);
				if (ch == '=')out(15, TOKEN);//>=
				else
				{
					fseek(fp, -1, 1);
					out(14, TOKEN);//>
				}
				break;
			case '+':
			{
				out(17, TOKEN);
				str[len] = '+';
				len++;
				break;
			}
			case '-':
			{
				out(18, TOKEN);
				str[len] = '-';
				len++;
				break;
			}

			case '*':
			{
				out(19, TOKEN);
				str[len] = '*';
				len++;
				break;
			}
			case '/':
			{
				out(20, TOKEN);
				str[len] = '/';
				len++;
				break;
			}
			case '('://新增识别左括号
			{
				out(21, TOKEN);
				str[len] = '(';
				len++;
				break;
			}
			case ')'://新增识别右括号
			{
				out(22, TOKEN);
				str[len] = ')';
				len++;
				break;
			}
			default: report_error(); break;
			}

	}
	return;
}

int main()
{
	cout << "请输入要分析的表达式：" << endl;
	char strr[50];
	int i = 0;//输入表达式的长度
	ofstream out1("E:\\AAAtest\\test.txt");
	out1.close();
	ofstream out("E:\\AAAtest\\test.txt", ios::out);
	while (true)//将表达式存入文件test
	{
		cin >> strr[i];
		out << strr[i];
		if (strr[i] == '#')break;
		i++;
	}
	out.close();
	FILE* fp1;
	FILE* fp2;
	fp2 = fopen("E:\\AAAtest\\result.txt", "w");
	fclose(fp2);
	fp1 = fopen("E:\\AAAtest\\test.txt", "r");
	if (!fp1)
	{
		printf("打开文件失败！");
	}
	scanner_example(fp1);//对test文件中的内容进行词法分析，存入result文件

	string temp;
	cout << endl;
	cout << "词法分析结果为：" << endl;
	ifstream myfile2("E:\\AAAtest\\result.txt", ios::in);
	if (!myfile2.is_open())
	{
		cout << "未成功打开文件" << endl;
	}
	while (getline(myfile2, temp))//输出rusult文件中的内容
	{
		cout << temp << endl;
	}
	myfile2.close();

	str[len] = '#';
	cout << endl;
	cout << "词法分析后表达式为：" << endl;
	for (int i = 0; i <= len; i++)
	{
		cout << str[i];
	}
	cout << endl;
	cout << endl;
	cout << "语法分析结果为：" << endl;

	int count;//步骤
	int state[100], stateIndex;//状态串及下标
	state[0] = 0; stateIndex = 0;//初始化状态串
	char inSymbol[100], outSymbol[100];//栈中符号串  余留符号串
	inSymbol[0] = '#';//初始化
	int inSymbolIndex = 0, outSymbolIndex = 0;
	string analysis;//分析动作
	for (int i = 0; i <= len; i++)
	{
		outSymbol[i] = str[i];
	}
	cout << "字符串长度为：" << len << endl;
	cout << "步骤" << "\t" << "状态" << "\t\t";
	cout << "栈中符号串" << "\t\t" << "余留符号串" << "\t\t";
	cout << "分析动作" << "\t\n";
	for (count = 1;;)
	{
		cout << count << fixed << setprecision(3) << "\t";
		for (int i = 0; i <= stateIndex; i++)//输出状态串
		{
			cout << state[i] << " " << fixed << setprecision(4);
		}
		cout << "\t\t";
		for (int i = 0; i <= inSymbolIndex; i++)//输出栈中符号串
		{
			cout << inSymbol[i] << " " << fixed << setprecision(4);
		}
		cout << "\t\t";
		for (int i = outSymbolIndex; i <= len; i++)//输出余留符号串
		{
			cout << outSymbol[i] << " " << fixed << setprecision(4);
		}
		cout << "\t\t";


		int row = state[stateIndex], column;//根据状态串和余留符号串查action表
		if (outSymbol[outSymbolIndex] == '(')column = 0;
		else if (outSymbol[outSymbolIndex] == ')')column = 1;
		else if (outSymbol[outSymbolIndex] == '+')column = 2;
		else if (outSymbol[outSymbolIndex] == '-')column = 3;
		else if (outSymbol[outSymbolIndex] == '*')column = 4;
		else if (outSymbol[outSymbolIndex] == '/')column = 5;
		else if (outSymbol[outSymbolIndex] == 'i')column = 6;
		else if (outSymbol[outSymbolIndex] == '#')column = 7;


		if (action[row][column] == "null")
		{
			cout << "error!" << endl;
			break;
		}
		else//查表不为空
		{
			analysis = action[row][column];
			cout << analysis << "\t";//输出分析动作
			if (analysis[0] == 's')//查到以s开头的分析动作
			{
				cout << endl;
				stateIndex++;
				if (analysis.length() == 3)
				{
					state[stateIndex] = ((int)(analysis[1]) - 48) * 10 + ((int)(analysis[2]) - 48);
				}
				else state[stateIndex] = (int)analysis[1] - 48;
				inSymbolIndex++;
				inSymbol[inSymbolIndex] = outSymbol[outSymbolIndex];
				outSymbolIndex++;
				count++;
			}
			else if (analysis[0] == 'r')//查到以r开头的分析动作
			{
				int temp = (int)analysis[1] - 48;
				cout << grammar[temp] << endl;
				stateIndex = stateIndex - grammarrightlength[temp];
				inSymbolIndex = inSymbolIndex + 1 - grammarrightlength[temp];
				inSymbol[inSymbolIndex] = grammarleft[temp];
				cout << " " << fixed << setprecision(3) << "\t";
				for (int i = 0; i <= stateIndex; i++)//输出状态串
				{
					cout << state[i] << " " << fixed << setprecision(4);
				}
				cout << "\t\t";
				for (int i = 0; i <= inSymbolIndex; i++)//栈中符号串
				{
					cout << inSymbol[i] << " " << fixed << setprecision(4);
				}
				cout << "\t\t";
				for (int i = outSymbolIndex; i <= len; i++)//余留符号串
				{
					cout << outSymbol[i] << " " << fixed << setprecision(4);
				}
				cout << "\t\t";


				int row2 = state[stateIndex], column2;//根据状态串和栈中符号串查go表
				if (inSymbol[inSymbolIndex] == 'E')column2 = 0;
				else if (inSymbol[inSymbolIndex] == 'T')column2 = 1;
				else if (inSymbol[inSymbolIndex] == 'F')column2 = 2;

				if (go[row2][column2] == -1)
				{
					cout << "error!" << endl;
					break;
				}
				else//不为空，输出
				{
					cout << "go[" << row2 << "," << column2 << "]=" << go[row2][column2] << endl;
					stateIndex++;
					state[stateIndex] = go[row2][column2];
					count++;
				}
			}
			else if (analysis == "acc")
			{
				cout << endl << "分析成功！";
				break;
			}

		}
	}

	fclose(fp1);
	fclose(fp2);
	return 0;
}

