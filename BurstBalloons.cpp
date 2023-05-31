// Time Complexity -> O(n^3)
// Space Complexity -> O(n^2)
class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n));
        
        for(int l = 1; l <= n; l++){
            for(int i = 0; i <= n-l; i++){
                int j = i+l-1;
                int currMax = INT_MIN;
                for(int k = i; k <= j; k++){
                    int left = 1;
                    int right = 1;
                    if(i != 0)
                        left = nums[i-1];
                    if(j != n-1)
                        right = nums[j+1];
                    
                    int before = 0;
                    int after = 0;
                    if(k != j)
                        after = dp[k+1][j];
                    if(k != i)
                        before = dp[i][k-1];
                    
                    currMax = max(currMax, before + left*nums[k]*right + after);
                }
                dp[i][j] = currMax;
            }
        }
        
        return dp[0][n-1];
    }
};