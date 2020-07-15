//Time complexity is O(K * N^2)
//Space complexity is O(N*K)
//This solution is submitted on leetcode

public class BigN154SuperEggDropDpSolution {
	class Solution {
		public int superEggDrop(int K, int N) {
			// edge case
			if (K == 0)
				return 0;
			int[][] dp = new int[K + 1][N + 1];
			for (int j = 1; j < dp[0].length; j++) {
				dp[1][j] = j;
			}

			for (int i = 2; i < dp.length; i++) {
				for (int j = 1; j < dp[0].length; j++) {
					dp[i][j] = Integer.MAX_VALUE;
					for (int l = 1; l <= j; l++) {
						int move = 1 + Math.max(dp[i - 1][l - 1], dp[i][j - l]);
						dp[i][j] = Math.min(dp[i][j], move);
					}
				}
			}
			return dp[dp.length - 1][dp[0].length - 1];
		}
	}
}