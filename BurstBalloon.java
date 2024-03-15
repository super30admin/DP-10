public class BurstBalloon {
    // TC: O(N * N * N) where N is length of nums array
    // SC: O(N * N) where N is length of nums array
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int first = 0;
                    if (i != k) {
                        first = dp[i][k - 1];
                    }
                    int last = 0;
                    if (j != k) {
                        last = dp[k + 1][j];
                    }
                    int left = 1;
                    if (i != 0) {
                        left = nums[i - 1];
                    }
                    int right = 1;
                    if (j + 1 < n) {
                        right = nums[j + 1];
                    }
                    max = Math.max(max, first +  left * nums[k] * right + last);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n - 1];
    }
}
