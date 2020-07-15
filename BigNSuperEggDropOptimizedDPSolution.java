//Time complexity is O(K * N)
//Space complexity is O(N*K)
//This solution is submitted on leetcode

public class BigNSuperEggDropOptimizedDPSolution {
	class Solution {
		public int superEggDrop(int K, int N) {
			// edge case
			if (K == 0)
				return 0;
			int[][] dp = new int[N + 1][K + 1];
			int attempts = 0; // here attempts acts as row
			while (dp[attempts][K] < N) {
				attempts++;
				for (int j = 1; j < dp[0].length; j++) {
					dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
				}
			}
			return attempts;
		}
	}
}