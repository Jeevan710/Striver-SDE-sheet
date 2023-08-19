class Solution {
public:

    void solve(int start,vector<int> n,vector<vector<int>> & arr)
    {
        if(start==n.size())
        {
            arr.push_back(n);
            return;
        }
        for(int i=start;i<n.size();i++)
        {
            swap(n[start],n[i]);
            solve(start+1,n,arr);
            swap(n[start],n[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        solve(0,nums,ans);
        return ans;
    }
};