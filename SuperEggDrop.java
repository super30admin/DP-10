// Time Complexity :O(k*n^2)
// Space Complexity :O(nk)
// Did this code successfully run on Leetcode :TLE
// Any problem you faced while coding this :No
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {// populating first row for one egg
            dp[1][i] = i;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int f = 1; f <= j; f++) {// if we start at each floor
                    dp[i][j] = Math.min(dp[i][j], 1 +
                            Math.max(dp[i - 1][f - 1], dp[i][j - f]));// we'll take maximum value of break and not break
                                                                      // for certainty
                }
            }
        }
        return dp[k][n];
    }
}

// ------------------OPTIMIZED---------------------------------------------
// Time Complexity :O(nk)
// Space Complexity :O(nk)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n + 1][k + 1];
        int attempts = 0;
        // we are calculating no of floors covered for no of attempts
        while (dp[attempts][k] < n) {
            attempts++;
            for (int j = 1; j <= k; j++) {
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }

        }
        return attempts;
    }
}