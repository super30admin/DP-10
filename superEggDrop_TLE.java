// Time Complexity : O(K*N^2) where K is the number of eggs and N is the number of floors
// Space Complexity : O(K*N) where K is the number of eggs and N is the number of floors
// Did this code successfully run on Leetcode : No, TLE
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class superEggDrop_TLE {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for (int i = 1; i <= N; i++) {
            dp[1][i] = i;
        } 
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]));
                }
            }
        }
        return dp[K][N];
    }
}