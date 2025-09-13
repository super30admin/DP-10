/**
first of all not greedy - if we start from greatest element burst, we dont get the answer
then exhaustive - do 0/1. see repeated subprob. Use DP

 */
class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int dp[][] = new int[n][n];

        for (int l = 1; l <= n; ++l) {
            for (int i = 0; i < n - l + 1; ++i) {
                int j = i + l - 1;

                for (int k = i; k <= j; ++k) {
                    int before = 0;
                    if (k != i) {
                        before = dp[i][k - 1];
                    }

                    int after = 0;
                    if (k != j) {
                        after = dp[k + 1][j];
                    }

                    int left = 1;
                    if (i != 0) {
                        left = nums[i - 1];
                    }

                    int right = 1;
                    if (j != n - 1) {
                        right = nums[j + 1];
                    }

                    dp[i][j] = Math.max(dp[i][j], before + (left * nums[k] * right) + after);
                }
            }
        }

        return dp[0][n - 1];
    }
}