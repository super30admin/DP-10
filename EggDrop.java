import java.util.Arrays;
//Time Complexity : O(NKlogN)
//Space Complexity : O(N^2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Similar to the burst balloons problem instead of multiplication part, replace
 * it with 1 + left and right sub problems. Here we apply binary search instead
 * of linear search for better optimization.
 *
 */
class Solution {
	public int superEggDrop(int k, int n) {
		int[][] dp = new int[k + 1][n + 1];
		for (int[] i : dp)
			Arrays.fill(i, -1);
		return solve(k, n, dp);
	}

	public int solve(int k, int n, int[][] dp) {
		if (k == 1 || n <= 1)
			return n;
		if (dp[k][n] != -1)
			return dp[k][n];
		int l = 1, r = n;
		int min = Integer.MAX_VALUE;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int left = solve(k - 1, mid - 1, dp);
			int right = solve(k, n - mid, dp);
			int temp = 1 + Math.max(left, right);
			if (left < right)
				l = mid + 1;
			else
				r = mid - 1;
			min = Math.min(min, temp);
		}
		return dp[k][n] = min;
	}
}