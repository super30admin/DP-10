//dp with permutations - 9/9 class
//time: O(n3)
//space: O(n2)
class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n));
        for(int len = 1; len <= n; len++) {
            for(int i = 0; i <= n-len; i++) {
                int j = i+len-1;
                int maxi = INT_MIN;
                for(int k = i; k <= j; k++) {
                    // before + left*kth*right + after
                    int before = 0;
                    if(i != k) {
                        before = dp[i][k-1];
                    }
                    int after = 0;
                    if(k != j) {
                        after = dp[k+1][j];
                    }
                    int left = 1;
                    if(i > 0) {
                        left = nums[i-1];
                    }
                    int right = 1;
                    if(j != n-1) {
                        right = nums[j+1];
                    }
                    maxi = max(maxi, before + left*nums[k]*right + after);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[0][n-1];
    }
};