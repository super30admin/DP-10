// Time Complexity : O(k*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class uncrackableEggDrop {
    public int superEggDrop(int n, int k) {
        int [][] dp = new int[n+1][k+1];
        int m = 0;
        while (dp[n][m] < k) {
            m += 1;
            for (int egg=1; egg<=n; egg++) {
                dp[egg][m] = dp[egg][m-1] + dp[egg-1][m-1] + 1;
            }
        }
        return m;
    }
}
