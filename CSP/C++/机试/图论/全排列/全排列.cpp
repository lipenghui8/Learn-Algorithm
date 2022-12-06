class Solution {
public:
    int v[10];
    vector<int> num;
    vector<vector<int>> res;
    void dfs(int x, vector<int> r) {
        if (x > num.size()) {
            res.push_back(r);
            return;
        }
        for (int i = 0; i < num.size(); i++) {
            if (v[i] == 0) {
                r.push_back(num[i]);
                v[i] = 1;
                dfs(x + 1, r);
                v[i] = 0;
                r.pop_back();
            }
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        num = nums;
        vector<int> r;
        dfs(1, r);
        return res;
    }
};