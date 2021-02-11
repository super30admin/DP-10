//Time - O(n^2)
//Space - O(n^2)
class Solution {
public:
    int maxCoins(vector<int>& nums) {
         int n = nums.size();
        vector<vector<int>> dp (n,vector<int> (n));
        
        for(int len = 1;len<=n;len++){
            for(int i = 0;i<=n-len;i++){
                int j = i+len-1;
                for(int k = i;k<=j;k++){
                    int before = 0,after = 0;
                    if(k!=0){
                        before = dp[i][k-1];
                    }
                    if(k!=n-1){
                        after = dp[k+1][j];
                    }
                    int lVal = 1, rVal = 1;
                    if(i!=0){
                        lVal = nums[i-1];
                    }
                    if(j!=n-1){
                        rVal = nums[j+1];
                    }
                    dp[i][j] = max(dp[i][j], (before + (lVal*nums[k]*rVal) + after));
                }
                
            }
        }

        return dp[0][n-1];
    }
};