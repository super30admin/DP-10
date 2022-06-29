// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        
        int[][] dp = new int[n ][n];
        
        for(int len = 1; len <= n; len++) { // length of the array
            for(int i = 0; i <= n - len; i++) {
                
                int j = i + len - 1;
                
                for(int k = i; k <= j; k++) {
                    int left = 0;
                    
                    if(k != i) {
                        left = dp[i][k - 1];
                    }
                    
                    int right = 0;
                    
                    if(j != k) {
                        right = dp[k + 1][j];
                    }
                    
                    int before = 1;
                    
                    if(i != 0) {
                        before = nums[i - 1];
                    }
                    
                    int after = 1;
                    
                    if(j != n - 1) {
                        after = nums[j + 1];
                    }
                    
                    dp[i][j] = Math.max(dp[i][j], left + (before * nums[k] * after) + right);
                }
            }
        }
        
        return dp[0][n -1];
    }
}