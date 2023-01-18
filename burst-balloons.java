// # Complexity
// - Time complexity: O(n^3)
// - Space complexity: O(n^2)

class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            // i is the starting index of our burstable array
            for (int i = 0; i <= n - len; i++) {
                // j is the ending index of our burtable array
                int j = i + len - 1;

                for (int k = i; k <= j; k++) {
                    int left = 0;
                    if (k != i) {
                        left = dp[i][k - 1];

                    }
                    int right = 0;

                    if (k != j) {
                        right = dp[k + 1][j];

                    }

                    int before = 1;
                    if (i != 0) {
                        before = nums[i - 1];

                    }
                    int after = 1;
                    if (j != n - 1) {
                        after = nums[j + 1];
                    }
                    dp[i][j] = Math.max(dp[i][j], left + before * nums[k] * after + right);

                }

            }
        }

        return dp[0][n - 1];
    }
}