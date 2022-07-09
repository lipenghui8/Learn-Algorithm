#include<bits/stdc++.h>
using namespace std;
int s[4][4];
int v[4][4];
int dx[] = { -1,1,0,0 };
int dy[] = { 0,0,-1,1 };
string dd[] = { "u","d","l" ,"r" };
struct node
{
    int x, y;
    string path = "";
};
void bfs(int nx,int ny)
{
    queue<node> q;
    q.push({nx,ny,""});
    v[nx][ny] = 1;
    while (!q.empty()) 
    {
        node nn = q.front();
        q.pop();
        if (nn.x == 3 && nn.y == 3) {
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (j * (i - 1) + j == s[i][j]) {

                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            int x = nn.x + dx[i];
            int y = nn.y + dy[i];
            string path = nn.path.append(dd[i]);
            if (x >= 1 && x <= 3 && y >= 1 && y <= 3&&v[x][y]==0) {
                
            }
        }
    }
}
int main()
{
    char k;
    int sx, sy;
    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 3; j++) {
            cin >> k;
            if (k >= '0' && k <= '9') {
                s[i][j] = k-'0';
            }
            else {
                s[i][j] = 0;
                sx = i;
                sy = j;
            }
        }
    }
    bfs(sx, sy);

    return 0;
}