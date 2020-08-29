//TC - O(KN)
//SC - O(KN)
class Solution2 {
	public int superEggDrop(int K, int N) {
		int[][] dp = new int[N + 1][K + 1];
		int attempts = 0;
		while (dp[attempts][K] < N) {
			attempts++;
			for (int j = 1; j <= K; j++) {
				dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
			}
		}
		return attempts;
	}
}