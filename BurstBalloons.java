// Time Complexity : O(n*n*n) where n = length of nums array
// Space Complexity : O(n*n) where n = length of nums array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//312. Burst Balloons (Hard) - https://leetcode.com/problems/burst-balloons/
// Time Complexity : O(n*n*n) where n = length of nums array
// Space Complexity : O(n*n) where n = length of nums array
class Solution {
	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int n = nums.length;
		int[][] dp = new int[n][n];

		// form all possible sub arrays of different lengths
		for (int l = 1; l <= n; l++) {
			for (int i = 0; i <= n - l; i++) { // starting indices of sub arrays
				int j = i + l - 1;

				for (int k = i; k <= j; k++) {
					// kth balloon bursting in the end
					// before + left*curr*right + after
					int left = 1;
					int right = 1;

					if (j != n - 1) {
						right = nums[j + 1];
					}

					if (i != 0) {
						left = nums[i - 1];
					}

					int before = 0;
					int after = 0;

					if (k != i) {
						before = dp[i][k - 1];
					}

					if (k != j) {
						after = dp[k + 1][j];
					}

					dp[i][j] = Math.max(dp[i][j], before + (left * nums[k] * right) + after);
				}
			}
		}

		return dp[0][n - 1];
	}
}