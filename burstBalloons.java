// Time Complexity : O(n^3)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    // approch 1 using dp matrix
    public static int maxCoins(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        // dp matrix
        int[][] dp = new int[n][n];
        // intially take one balloon and burst it and every time
        // increase the size of the balloon window and use sliding window
        // to count maximum at each point and choose everytime
        // which balloon will burst last

        // size of the window is 1 -> n
        for (int l = 1; l <= n; l++) {
            // start index of the window
            for (int i = 0; i <= n - l; i++) {
                // end index of the window
                int j = i + l - 1;
                // go over the end indexes
                int max = 0;
                for (int k = i; k <= j; k++) {
                    // left balloon
                    int left = 1;
                    // right balloon
                    int right = 1;
                    // bound check
                    if (i != 0) {
                        left = nums[i - 1];
                    }
                    if (j != n - 1) {
                        right = nums[j + 1];
                    }
                    // left * curr * right
                    int curr = left * nums[k] * right;
                    // before the current window burst
                    int before = 0;
                    // after the current window burst
                    int after = 0;
                    if (k != i) {
                        before = dp[i][k - 1];
                    }
                    if (k != j) {
                        after = dp[k + 1][j];
                    }
                    // take maximum
                    max = Math.max(max, before + curr + after);
                }
                // update maximum at dp matrix
                dp[i][j] = max;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 1, 5, 8 };
        System.out.println(maxCoins(nums));
    }
}