// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int l = 1; l <= n; l++){
            for(int i = 0; i <= n - l; i++){ // i is the start index of all the burstible array
                int j = i + l - 1; // end index of burstible array
                for(int k = i; k <= j; k++){
                    int before = 0;
                    int after = 0;
                    if(k > i){
                        before = dp[i][k - 1];
                    }
                    if(k < j){
                        after = dp[k + 1][j];
                    }
                    int left = 1;
                    int right = 1;
                    if(i > 0){
                        left = nums[i - 1];
                    }
                    if(j < n - 1){
                        right = nums[j + 1];
                    }
                    dp[i][j] = Math.max(dp[i][j], (before + left * nums[k] * right + after));
                }
            }
        }
        return dp[0][n-1];
    }
}