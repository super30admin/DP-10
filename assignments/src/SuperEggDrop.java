// Time: O(knlogn)
// Space: O(kn)

class SuperEggDrop {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        int attempts = 0;
        while(dp[attempts][k] < n) {
            attempts++;
            for (int j = 1; j<=k; j++) {
                dp[attempts][j] = 1 + dp[attempts-1][j] + dp[attempts-1][j-1];
            }
        }
        return attempts;
    }
}