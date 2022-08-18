// Time Complexity :O(n^3)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        // first we are taking length of array we are considering
        for (int l = 1; l <= n; l++) {
            // now in that subarray, we take start and end index
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                dp[i][j] = 0;
                // k is the index which we are bursting in end
                for (int k = i; k <= j; k++) {
                    // balloon burst before k
                    int before = 0;
                    if (i != k) {
                        before = dp[i][k - 1];
                    }
                    // balloon burst after k
                    int after = 0;
                    if (j != k) {
                        after = dp[k + 1][j];
                    }
                    // for bursting current/k balloon, taking left amount, right amount and k amount
                    int left = 1;
                    if (i != 0) {
                        left = nums[i - 1];
                    }
                    int right = 1;
                    if (j != n - 1) {
                        right = nums[j + 1];
                    }
                    int curr = left * right * nums[k];
                    // storing maximum value for same array for different k
                    dp[i][j] = Math.max(dp[i][j], before + curr + after);

                }
            }
        }
        return dp[0][n - 1];
    }
} 