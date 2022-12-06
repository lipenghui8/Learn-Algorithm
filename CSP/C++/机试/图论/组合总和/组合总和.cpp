class Solution {
public:
    vector<int> c;
    vector<vector<int>> sres;
    int t;
    void dfs(int x, vector<int> res, int p = 0) {
        if (x >= t) {
            if (x == t) {
                sres.push_back(res);
            }
            return;
        }
        for (int i = p; i < c.size(); i++) {
            res.push_back(c[i]);
            x = x + c[i];
            dfs(x, res, i);
            x = x - c[i];
            res.pop_back();
        }
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        c = candidates;
        t = target;
        vector<int> p;
        dfs(0, p);
        return sres;
    }
};