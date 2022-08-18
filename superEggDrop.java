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