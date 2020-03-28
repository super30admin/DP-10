// Time Complexity : O(n^3) where n is the length of the array nums
// Space Complexity : O(n^2) where n is the length of the array nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class balloonBurst {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) { // start index of subarray
                int j = i + len - 1; // end index of subarray
                for (int k = i; k <= j; k++) { // iterating thru subarray
                    int leftVal = 1, rightVal = 1;
                    if (i != 0) leftVal = nums[i-1];
                    if (j != n-1) rightVal = nums[j+1];
                    int before = 0, after = 0;
                    if (i != k) {
                        before = dp[i][k-1];
                    }
                    if (j != k) {
                        after = dp[k+1][j];
                    }
                    dp[i][j] = Math.max(dp[i][j], before + leftVal * nums[k] * rightVal + after);
                }
            }
        }
        return dp[0][n-1];
    }
}