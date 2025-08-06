// TC: O(n^3)
// SC: O(n^2)
class Solution {
    int[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];

        for (int le = 1; le <= n; le++) {

            for (int i = 0; i <= n - le; i++) {

                int j = i + le - 1;
                int max = Integer.MIN_VALUE;

                for (int k = i; k <= j; k++) {

                    int before = 0;
                    int after = 0;

                    if (i != k) {
                        before = dp[i][k - 1];
                    }
                    if (k != j) {
                        after = dp[k + 1][j];
                    }
                    int left = 1;
                    int right = 1;
                    if (i > 0) {
                        left = nums[i - 1];
                    }
                    if (j < n - 1) {
                        right = nums[j + 1];
                    }
                    int balloon = left * nums[k] * right;
                    int total = before + balloon + after;
                    dp[i][j] = Math.max(dp[i][j], total);;
                }
            }
        }
        return dp[0][n - 1];
    }
}