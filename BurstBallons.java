package com.example.problems;

//Time Complexity : O(N^3) for Recursive Approach O(N) for DP 
//Space Complexity : O(N^2
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
 * We define a function dp to return the maximum number of coins obtainable on the open interval (left, right). Our base case is if there are no integers on our interval (left + 1 == right), and therefore there are no more balloons that can be added. We add each balloon on the interval, divide and conquer the left and right sides, and find the maximum score.

The best score after adding the ith balloon is given by:

nums[left] * nums[i] * nums[right] + dp(left, i) + dp(i, right)
nums[left] * nums[i] * nums[right] is the number of coins obtained from adding the ith balloon, and dp(left, i) + dp(i, right) are the maximum number of coins obtained from solving the left and right sides of that balloon respectively
We have used DP to cache the result of recursive apporach to avoid re-computation 
*/
public class BurstBallons {
	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int size = nums.length;
		int dp[][] = new int[size][size];

		for (int len = 1; len <= size; len++) {
			int remaining = size - len;
			for (int i = 0; i <= remaining; i++) {
				int j = i + len - 1;
				for (int k = i; k <= j; k++) {
					int left = 1;
					int right = 1;

					if (i != 0) {
						left = nums[i - 1];
					}
					if (j != size - 1) {
						right = nums[j + 1];
					}
					int before = 0, after = 0;
					if (i != k) {
						before = dp[i][k - 1];
					}
					if (j != k) {
						after = dp[k + 1][j];
					}
					dp[i][j] = Math.max(dp[i][j], before + left * nums[k] * right + after);
				}
			}
		}
		return dp[0][size - 1];
	}

	public static void main(String args[]) {
		int nums[] = { 3, 1, 5, 8 };

		BurstBallons ballons = new BurstBallons();

		System.out.println(ballons.maxCoins(nums));
	}
}
