// Time Complexity: O(n^3)
// Space Complexity: O(n^2) size of dp matrix
class Solution {
public:
    int maxCoins(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for(int len = 1; len <= n; len++) {
            for(int i = 0; i <= n-len; i++) { // i is starting index of the deciding array
                int j = i+len-1; // j is ending index of the deciding array
                for(int k = i; k <= j; k++) {
                    int leftVal = 1;
                    int rightVal = 1;
                    if(i != 0)
                        leftVal = nums[i-1];
                    if(j != n-1)
                        rightVal = nums[j+1];
                    int before = 0;
                    int after = 0;
                    if(k != 0)
                        before = dp[i][k-1];
                    if(k != n-1)
                        after = dp[k+1][j];
                    dp[i][j] = max(dp[i][j], before + leftVal*nums[k]*rightVal + after);
                }
            }
        }
        return dp[0][n-1];
    }
};
