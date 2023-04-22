/*
Super Egg Drop
approach: dp with permutations, to avoid third loop, re-phrase the problem to "with m moves & e eggs how many floors we can explore?"
time: 1. O((nxn)xk) 2. O(nxk)
space: both: O(nk)
 */
public class Problem2 {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];

        for (int j = 1;j<=n;j++) {
            dp[1][j] = j;
        }

        for (int i=2;i<=k;i++) {
            for (int j=1;j<=n;j++) {
                int min = Integer.MAX_VALUE;

                for (int f = 1;f<=j;f++) {
                    min = Math.min(1+Math.max(dp[i-1][f-1], dp[i][j-f]), min);
                }
                dp[i][j] = min;
            }
        }
        return dp[k][n];
    }

    public int superEggDropOptimized(int k, int n) {
        int[][] dp = new int[n+1][k+1];

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=k;j++) {
                dp[i][j] = 1+dp[i-1][j-1]+dp[i-1][j];
                if (dp[i][j]>=n) return i;
            }
        }
        return n;
    }
}
