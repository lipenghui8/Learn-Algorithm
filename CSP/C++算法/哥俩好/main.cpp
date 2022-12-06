#include <iostream>
#include <algorithm>
using namespace std;

const int MAX_N = 1010;
int W[MAX_N], V[MAX_N];
int f[MAX_N]; // һ��
int N, M;

int main()
{
    cin >> N >> M;
    for (int i = 1; i <= N; i++)
        cin >> V[i] >> W[i];
    for (int i = 1; i <= N; i++)
    {
        // �Ӵ�С
        for (int j = M; j >= V[i]; j--)
        {
            // ԭ���ǣ�
            // ����f[j]��ʵ���õ���һ���
            // ��f[i-1][j]
            f[j] = max(f[j], f[j - V[i]] + W[i]);
        }
    }
    cout << f[M];
    return 0;
}
