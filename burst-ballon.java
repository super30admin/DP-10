// TC: O(n^3)
// SC: O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public int maxCoinsBottomUpDp(int[] nums) {
    int n = nums.length;
    int[][] T = new int[n][n];

    // Consider all subarrays of length len
    for (int len = 1; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            // Consider each possible k in the subarray nums[i..j] as the last balloon to burst
            for (int k = i; k <= j; k++) {
                // Determine left and right values.
                // If there's an element to the left of the current subarray, take it; otherwise, default to 1.
                int leftValue = (i == 0) ? 1 : nums[i - 1];
                // Similarly for the right side.
                int rightValue = (j == n - 1) ? 1 : nums[j + 1];

                // 'before' is the coins from bursting balloons from i to k-1
                int before = (i == k) ? 0 : T[i][k - 1];
                // 'after' is the coins from bursting balloons from k+1 to j
                int after = (j == k) ? 0 : T[k + 1][j];

                // Update T[i][j] with the maximum coins for the subarray from i to j
                T[i][j] = Math.max(T[i][j], leftValue * nums[k] * rightValue + before + after);
            }
        }
    }
    return T[0][n - 1];
}
