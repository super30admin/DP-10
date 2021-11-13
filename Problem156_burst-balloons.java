// Time Complexity: O(n^3)
// Space Complexity: O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null)
            return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int len = 1; len <= n; len++) {
            // starting point of those len arrays
            for(int i = 0; i <= n - len; i++) {
                // end index of those arrays of certain len
                int j = i + len - 1;
                for(int k = i; k <= j; k++) {
                    // before
                    int before = 0;
                    int after = 0;
                    if(i != k) {
                        before = dp[i][k - 1];
                    }
                    // after 
                    if(j != k) {
                        after = dp[k + 1][j];
                    }
                    
                    // end balloon
                    // left
                    int left = 1; int right = 1;
                    if(i != 0) {
                        left = nums[i - 1];
                    }
                    // right
                    if(j != n-1) {
                        right = nums[j + 1];
                    }
                    dp[i][j] = Math.max(dp[i][j], before + left * nums[k] * right + after);
                }
            }
        }
        return dp[0][n - 1];
    }
}
// before + left*balloon + after