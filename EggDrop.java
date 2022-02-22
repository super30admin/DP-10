// Time Complexity : O(nk)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use dp to solve this
// we create a 2d array with attemps and eggs
// then we calculate dp[attempts][j]
class Solution {
    public int superEggDrop(int k, int n) {
        if (n == 0)
            return 0;
        int[][] dp = new int[n + 1][k + 1];
        int attempts = 0;
        while (dp[attempts][k] < n) {
            attempts++;
            for (int j = 1; j <= k; j++) {
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j];
            }
        }
        return attempts;
    }
}