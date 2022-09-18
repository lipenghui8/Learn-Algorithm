#include<bits/stdc++.h>
using namespace std;

struct node
{
    int id, s[4], rank[4],best;
}stu[2001];
int ex[1000000];
int f = 0;
bool cmp(node s1, node s2) {
    return s1.s[f] > s2.s[f];
}
int main()
{
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        scanf("%d %d %d %d", &stu[i].id, &stu[i].s[1], &stu[i].s[2], &stu[i].s[3]);
        stu[i].s[0] = (stu[i].s[1]+ stu[i].s[2]+ stu[i].s[3])/3;
    }
    for (f = 0; f < 4; f++) {
        sort(stu, stu + n, cmp);
        stu[0].rank[f] = 1;
        for (int j = 1; j < n; j++) {
            stu[j].rank[f] = j + 1;
            if (stu[j].s[f] == stu[j - 1].s[f]) {
                stu[j].rank[f] = stu[j - 1].rank[f];
            }
        }
    }
    for (int i = 0; i < n; i++) {
        ex[stu[i].id] = i + 1;
        stu[i].best = 0;
        int minn = stu[i].rank[0];
        for (int j = 1; j <= 3; j++) {
            if (stu[i].rank[j] < minn) {
                minn = stu[i].rank[j];
                stu[i].best = j;
            }
        }
    }
    int id;
    char c[5] = { 'A', 'C', 'M', 'E' };
    for (int i = 0; i < m; i++) {
        scanf("%d", &id);
        int temp = ex[id];
        if (temp) {
            int best = stu[temp - 1].best;
            printf("%d %c\n", stu[temp - 1].rank[best], c[best]);
        }
        else {
            printf("N/A\n");
        }
    }
    return 0;
}