
// Time Complexity :O(n^3)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :i still hard find it hard to code the solution out

// I understand the the appraoch but still hard to wrap my head about the code

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int total = 0;
                    int left_burst = 0;
                    if (k != i) {
                        left_burst = dp[i][k - 1];
                    }
                    int right_burst = 0;
                    if (k != j) {
                        right_burst = dp[k + 1][j];
                    }
                    int left_ne = 1;
                    if (i != 0) {
                        left_ne = nums[i - 1];
                    }
                    int right_ne = 1;
                    if (j != n - 1) {
                        right_ne = nums[j + 1];
                    }
                    total = left_burst + left_ne * nums[k] * right_ne + right_burst;
                    max = Math.max(max, total);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n - 1];
    }
}