#include <bits/stdc++.h>
using namespace std;
int m, n, sum;
int dx[] = { -1,1,0,0 };
int dy[] = { 0,0,-1,1 };
char s[25][25];
int v[25][25];
int ax, ay;
struct node {
    int x, y;
};
void bfs()
{
    queue<node> q;
    q.push({ ax,ay });
    v[ax][ay] = 1;
    while (!q.empty()) {
        node nn = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            int x = nn.x + dx[i];
            int y = nn.y + dy[i];
            if (x >= 1 && x <= m && y >= 1 && y <= n && v[x][y] == 0 && s[x][y] == '.') {
                v[x][y] = 1;
                sum += 1;
                q.push({x,y});
            }
        }
    }
}

int main()
{
    cin >> n >> m;
    while (n != 0 && m != 0) {
        memset(s, 0, sizeof(s));
        memset(v, 0, sizeof(v));
        sum = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cin >> s[i][j];
                if (s[i][j] == '@') {
                    ax = i;
                    ay = j;
                }
            }
        }
        bfs();
        cout << sum + 1 << endl;
        cin >> n >> m;
    }
    return 0;
}
