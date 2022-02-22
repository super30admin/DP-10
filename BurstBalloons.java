
// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use dp to solve this
// we create a 2d array with no.of balloons 
// then we calculate dp[i][j]

class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int before = 0, after = 0;
                    if (k != i) {
                        before = dp[i][k - 1];
                    }
                    if (k != j) {
                        after = dp[k + 1][j];

                    }
                    int left = 1, right = 1;
                    if (i != 0) {
                        left = nums[i - 1];
                    }
                    if (j != n - 1) {
                        right = nums[j + 1];
                    }
                    dp[i][j] = Math.max(dp[i][j], before + left * nums[k] * right + after);
                }
            }
        }
        return dp[0][n - 1];
    }
}