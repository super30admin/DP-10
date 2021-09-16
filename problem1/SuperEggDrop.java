// Time Complexity : O(n^2), n -> Number of balloons
// Space Complexity : O(n*k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class SuperEggDrop {
	/********************* DP *********************/
	// Time Complexity : O(n^3), n -> Number of balloons
	// Space Complexity : O(n*k)
	// Did this code successfully run on Leetcode : Time Limit Exceeded
	// Any problem you faced while coding this : No
	public int superEggDropDP(int k, int n) {
		if (n == 0 && k == 0) {
			return 0;
		}

		if (k == 0) {
			return Integer.MAX_VALUE;
		}

		if (k == 1) {
			return n;
		}

		int[][] dp = new int[k + 1][n + 1];

		/*
		 * We can fill 0th row with Integer.MAX_VALUE, but we are choosing not to. We
		 * are filling first row with value of column
		 */
		for (int j = 1; j <= n; j++) {
			dp[1][j] = j;
		}

		// Eggs
		for (int i = 2; i < dp.length; i++) {
			// Floors
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				// Drop egg from each floor to get minimum value
				for (int f = 1; f <= j; f++) {
					dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][f - 1], dp[i][j - f]));
				}
			}
		}
		return dp[k][n];
	}

	/********************* Optimized DP *********************/
	// Time Complexity : O(n^2), n -> Number of balloons
	// Space Complexity : O(n*k)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int superEggDrop(int k, int n) {
		if (n == 0 && k == 0) {
			return 0;
		}

		if (k == 0) {
			return Integer.MAX_VALUE;
		}

		if (k == 1) {
			return n;
		}

		int[][] dp = new int[n + 1][k + 1];
		int attempts = 0;

		while (dp[attempts][k] < n) {
			attempts++;

			for (int j = 1; j <= k; j++) {
				dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
			}
		}

		return attempts;
	}

	public static void main(String[] args) {
		SuperEggDrop obj = new SuperEggDrop();
		int n = 4;
		int k = 2;

		System.out.println("Minimum number of moves to determine the value of \'f\': " + obj.superEggDrop(k, n));
	}

}
