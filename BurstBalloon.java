// Time Complexity : O(N^3)
// Space Complexity : O(MxN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int len = 1; len <= n; len++){
            for(int i = 0; i <= n-len; i++){
                int j = len + i - 1;
                for(int k = i; k <= j; k++){
                    int leftval = 1;
                    int rightval = 1;
                    if(i != 0){
                        leftval = nums[i-1];
                    }
                    if( j != n - 1){
                        rightval = nums[j+1];
                    }
                    
                    int before = 0;
                    int after = 0;
                    
                    if( i != k){
                        before = dp[i][k-1];
                    }
                    if( j != k){
                        after = dp[k+1][j];
                    }
                    dp[i][j] = Math.max((before + leftval * nums[k] * rightval + after), dp[i][j]);
                }
            }
        }
        
        return dp[0][nums.length - 1];
    }
}