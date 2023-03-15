// Approach: DP with permutations.
// Calculate Max points by taking different length arrays and maintain a table dp[][].
// The trick: Use "balloon to be burst in the end" for each permutation.
// Finally return the top right most cell value.
// Only the top right triangle will be filled in the table.
// Time: O(n^3)
// Space: O(m*n) for dp[][] array.

class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int l = 1; l<=n; l++) {
            for (int i = 0; i<=n-l; i++) {   // i is the start index of all burstible arrays
                int j = i+l - 1;            // end index of burstible arrays

                for (int k = i; k<=j; k++) {    // for permutations
                    int before = 0, after = 0;

                    if (k > i) {
                        before = dp[i][k-1];
                    }
                    if (k < j) {
                        after = dp[k+1][j];
                    }

                    int left = 1, right = 1;    // if no other balloons on left/right, take it as 1

                    if (i > 0) {
                        left = nums[i-1];
                    }
                    if (j < n-1) {
                        right = nums[j+1];
                    }

                    dp[i][j] = Math.max(dp[i][j], (before + (left*nums[k]*right) + after));
                }
            }
        }
        return dp[0][n-1];
    }
}