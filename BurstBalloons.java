//Time Complexity : O(N^3)
//Space Complexity : O(N^2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take a dp matrix of size n+2, n+2 since 2 1s will be added to each end. Then
 * start from 1 to end-1 position of nums array. Take max of the multiplication
 * of left, right and current index of nums added to remaining elements
 * subproblems on both sides. update them to the dp matrix and return the ans.
 *
 */
class Solution {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		int arr[] = new int[n + 2];
		arr[0] = arr[n + 1] = 1;
		for (int i = 1; i <= n; i++) {
			arr[i] = nums[i - 1];
		}

		int memo[][] = new int[n + 2][n + 2];
		return burst(memo, arr, 0, n + 1);

	}

	public int burst(int[][] memo, int[] nums, int left, int right) {
		if (left + 1 == right)
			return 0;

		if (memo[left][right] > 0)
			return memo[left][right];

		int ans = 0;

		for (int i = left + 1; i < right; ++i) {
			ans = Math.max(ans,
					nums[left] * nums[i] * nums[right] + burst(memo, nums, left, i) + burst(memo, nums, i, right));
		}
		memo[left][right] = ans;

		return ans;
	}
}