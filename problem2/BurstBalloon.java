// Time Complexity : O(n^3), n -> Number of balloons
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class BurstBalloon {
	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;

		int[][] dp = new int[n][n];

		for (int len = 1; len <= n; len++) {
			for (int start = 0; start <= n - len; start++) {
				int end = start + len - 1;

				for (int last = start; last <= end; last++) {
					int burstLeft = 0;
					int burstRight = 0;

					if (last != start) {
						burstLeft = dp[start][last - 1];
					}

					if (last != end) {
						burstRight = dp[last + 1][end];
					}

					int left = 1;
					int right = 1;

					if (start != 0) {
						left = nums[start - 1];
					}

					if (end != n - 1) {
						right = nums[end + 1];
					}

					dp[start][end] = Math.max(dp[start][end], burstLeft + (left * nums[last] * right) + burstRight);
				}
			}
		}

		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		BurstBalloon obj = new BurstBalloon();
		int[] nums = { 2, 3, 5, 7 };

		System.out.println("Maximum coins: " + obj.maxCoins(nums));
	}

}
