#include <iostream>
#include <algorithm>
using namespace std;

const int MAX_N = 1010;
int W[MAX_N], V[MAX_N];
int f[MAX_N]; // 一层
int N, M;

int main()
{
    cin >> N >> M;
    for (int i = 1; i <= N; i++)
        cin >> V[i] >> W[i];
    for (int i = 1; i <= N; i++)
    {
        // 从大到小
        for (int j = M; j >= V[i]; j--)
        {
            // 原因是：
            // 现在f[j]其实是用的上一层的
            // 即f[i-1][j]
            f[j] = max(f[j], f[j - V[i]] + W[i]);
        }
    }
    cout << f[M];
    return 0;
}
