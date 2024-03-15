public class SuperEggDrop {
    // TC: O(N * K)
    // SC: O(N * K)
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n + 1][k + 1];
        int attempts = 0;
        while (dp[attempts][k] < n) {
            attempts++;
            for (int i = 1; i <= k; i++) {
                dp[attempts][i] = 1 + dp[attempts - 1][i] + dp[attempts - 1][i - 1];
            }
        }
        return attempts;
    }
}
