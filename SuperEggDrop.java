// Time Complexity : O(k * N) --> where K is the number of eggs and N is the number of floors
// Space Complexity : O(k * N)
// Did this code successfully run on Leetcode (887): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int superEggDrop(int K, int N) {
        int dp[][] = new int[N+1][K+1];
        int attempts = 0;
        while (dp[attempts][K] < N) {
            attempts++;
            for (int j = 1; j <= K; j++) {
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j];
                if (dp[attempts][j] >= N) return attempts;
            }
        }
        return attempts;
    }
}