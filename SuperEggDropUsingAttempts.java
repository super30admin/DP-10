public class SuperEggDropUsingAttempts {
	// O(N*K)
	public int superEggDrop(int K, int N) {
		int[][] dp = new int[N + 1][K + 1];

		int attempt = 0;
		while (dp[attempt][K] < N) {
			attempt++;
			for (int j = 1; j <= K; j++) {

				dp[attempt][j] = 1 + dp[attempt - 1][j - 1] + dp[attempt - 1][j];

			}

		}

		return attempt;

	}
}
