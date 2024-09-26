// Time Complexity : O(N^3)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int maxCoins(int[] nums) {
        // if(nums == null || nums.length == 0) {
        //     return 0;
        // }
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int length = 1; length <= n; length++) {
            for(int i = 0; i <= n-length;i++) {
                int j = i + length - 1;
                for(int k = i; k <= j; k++) {
                    int burstLeft = 0; 
                    int burstRight = 0;
                    
                    if(k != i) {
                        burstLeft = dp[i][k-1];
                    }
                    if(k != j) {
                         burstRight = dp[k+1][j];
                    }
                    int left = 1; 
                    int right = 1;
                    if(i != 0) {
                        left = nums[i-1];
                    }
                    if(j != n-1) {
                        right = nums[j+1];
                    }
                    dp[i][j] = Math.max(dp[i][j], burstLeft + left * nums[k] * 
                                                right + burstRight);
                }
            }
        }
        return dp[0][n-1];
    }
}

class Solution {
    public int superEggDrop(int k, int n) {
        if( k == 0 && n == 0) {
            return 0;
        }
        if(k == 1) {
            return n;
        }
        int[][] dp = new int[n+1][k+1];
        int attempts = 0;
        
        while(dp[attempts][k] < n) {
            attempts++;
            for(int j = 1;j <= k; j++) {
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
            }
        }
        return attempts;
    }
    
}