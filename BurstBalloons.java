// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0)
            return 0;
        int[][] dp = new int[n][n];

        // subproblem of different lengths
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int before = 0;
                    if (i != k) {
                        before = dp[i][k - 1];
                    }
                    int after = 0;
                    if (k != j) {
                        after = dp[k + 1][j];
                    }
                    // at the balloon
                    int left = 1;
                    if (i > 0) {
                        left = nums[i - 1];
                    }

                    int right = 1;
                    if (j != n - 1) {
                        right = nums[j + 1];
                    }
                    max = Math.max(max, before + left * nums[k] * right + after);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n - 1];
    }
}